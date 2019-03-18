/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hfsframework.admin.data.AdmPerfilRepository;
import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.model.AdmUsuarioPerfil;
import br.com.hfsframework.admin.model.AdmUsuarioPerfilPK;
import br.com.hfsframework.base.BaseBusinessService;
import br.com.hfsframework.security.model.MenuVO;
import br.com.hfsframework.security.model.PerfilVO;
import br.com.hfsframework.security.model.PermissaoVO;
import br.com.hfsframework.security.model.UsuarioAutenticadoVO;
import br.com.hfsframework.util.exceptions.TransacaoException;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmPerfilService.
 */
@Service
public class AdmPerfilService extends BaseBusinessService<AdmPerfil, Long, AdmPerfilRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AdmMenuService admMenuService;
	
	@Autowired
	private AdmUsuarioService admUsuarioService;
	
	@Autowired
	private AdmUsuarioPerfilService admUsuarioPerfilService;

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#load(java.io.Serializable)
	 */
	@Override
	public Optional<AdmPerfil> load(Long id) {
		Optional<AdmPerfil> item = super.load(id);
		item.get().setAdmUsuarios(this.findUsuariosPorPerfil(item.get()));
		return item;
	}
	
	/**
	 * Atribui o adm usuario cargo.
	 *
	 * @param lista
	 *            the lista
	 * @return the list
	 */
	private Iterable<AdmPerfil> setAdmUsuarioCargo(Iterable<AdmPerfil> lista) {
		for (AdmPerfil item : lista) {
			item.setAdmUsuarios(this.findUsuariosPorPerfil(item));
		}
		
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#findAll()
	 */
	@Override
	public Iterable<AdmPerfil> findAll() {
		Iterable<AdmPerfil> lista = super.findAll();		
		return setAdmUsuarioCargo(lista);
	}
	
	/**
	 * Atribui o cargos usuarios.
	 *
	 * @param bean
	 *            the bean
	 */
	private void setPerfisUsuarios(Optional<AdmPerfil> bean) {
		AdmUsuarioPerfil admUsuarioPerfil; 
		AdmUsuarioPerfilPK admUsuarioPerfilPK;

		for (AdmUsuario usuario : bean.get().getAdmUsuarios()) {
			
			admUsuarioPerfilPK = new AdmUsuarioPerfilPK();
			admUsuarioPerfilPK.setPerfilSeq(bean.get().getId());
			admUsuarioPerfilPK.setUsuarioSeq(usuario.getId());
			
			admUsuarioPerfil = new AdmUsuarioPerfil();
			admUsuarioPerfil.setId(admUsuarioPerfilPK);
			admUsuarioPerfil.setAdmPerfil(bean.get());
			
			admUsuarioPerfilService.insert(admUsuarioPerfil);
		}
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#delete(java.lang.Object)
	 */
	@Override
	@Transactional
	public void delete(AdmPerfil bean) throws TransacaoException {
		super.delete(bean);		
		admUsuarioPerfilService.deleteByPerfil(bean.getId());
	}


	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#insert(java.lang.Object)
	 */
	@Override
	@Transactional
	public Optional<AdmPerfil> insert(AdmPerfil bean) throws TransacaoException {
		Optional<AdmPerfil> novo = super.insert(bean);
		if (novo.isPresent()) {
			setPerfisUsuarios(novo);
		}
		return novo;
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#update(java.lang.Object)
	 */
	@Override
	@Transactional
	public Optional<AdmPerfil> update(AdmPerfil bean) throws TransacaoException {
		Optional<AdmPerfil> alterado = super.update(bean);
		admUsuarioPerfilService.deleteByPerfil(bean.getId());
		admUsuarioPerfilService.deleteByUsuarios(bean.getAdmUsuarios());
		setPerfisUsuarios(Optional.of(bean));	
		return alterado;
	}	
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#getDescricao(java.io.Serializable)
	 */
	@Override
	public String getDescricao(Long id){
		return repositorio.getDescricao(id);
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#existeNovo(java.lang.String)
	 */
	@Override
	public boolean existeNovo(String novo){
		Long existe = repositorio.countNovo(novo.toLowerCase());
		return (existe > 0);
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#existeAntigoNovo(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean existeAntigo(Long id, String novo){
		String antigo = getDescricao(id);
		Long existe = repositorio.countAntigo(antigo.toLowerCase(), novo.toLowerCase());
		return (existe > 0);
	}
	
	/**
	 * Gets the papeis.
	 *
	 * @param idAdmUsuario the id adm usuario
	 * @return the papeis
	 */
	public HashSet<AdmPerfil> getPapeis(Long idAdmUsuario) {
		HashSet<AdmPerfil> hs = new HashSet<AdmPerfil>();

		//AdmUsuario admUsuario = new AdmUsuario(usuarioAutenticado.getUsuario());		
		Iterable<AdmPerfil> lst = repositorio.findPerfisPorUsuario(idAdmUsuario);		
		lst = setAdmUsuarioCargo(lst);
		/*
		for (AdmPerfil g : lst) {
			hs.add(g);
		}
		*/
		lst.forEach(g -> hs.add(g));
		
		Optional<AdmPerfil> g = load(1L); // GERAL
		hs.add(g.get());

		return hs;
	}

	public List<PermissaoVO> getPermissao(UsuarioAutenticadoVO usuarioAutenticado){
		AdmUsuario admUsuario = new AdmUsuario(usuarioAutenticado.getUsuario());
		return getPermissao(admUsuario.getId());
	}
	
	public List<PermissaoVO> getPermissao(Long idAdmUsuario) {
		List<PermissaoVO> lista = new ArrayList<PermissaoVO>();
		PermissaoVO permissao;
		
		Iterable<AdmPerfil> perfis = repositorio.findPerfisPorUsuario(idAdmUsuario);
		perfis = setAdmUsuarioCargo(perfis);
		
		for (AdmPerfil perfil : perfis) {
			permissao = new PermissaoVO();
			permissao.setPerfil(perfil.toPerfilVO());
		
			for (AdmPagina admPagina : perfil.getAdmPaginas()) {
				permissao.getPaginas().add(admPagina.toPaginaVO());
			}
			
			lista.add(permissao);
		}
		
		return lista;
	}
	
	/**
	 * Find admin menu pai by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	public List<AdmMenu> findAdminMenuPaiByPerfil(AdmPerfil perfil){
		List<AdmMenu> lista = repositorio.findAdminMenuPaiByPerfil(perfil);
		for (AdmMenu admMenu : lista) {
			admMenu.setAdmSubMenus(repositorio.findAdminMenuByPerfil(perfil, admMenu));
		}
		return lista;
	}

	/**
	 * Find menu pai by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	public List<AdmMenu> findMenuPaiByPerfil(AdmPerfil perfil){
		List<AdmMenu> lista = repositorio.findMenuPaiByPerfil(perfil);
		for (AdmMenu admMenu : lista) {
			admMenu.setAdmSubMenus(repositorio.findMenuByPerfil(perfil, admMenu));
		}
		return lista;
	}
	
	/**
	 * Find admin menu pai by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	public List<MenuVO> findAdminMenuPaiByPerfil(PerfilVO perfil){
		AdmPerfil perfilAdminPai = new AdmPerfil(perfil);
		List<AdmMenu> listaAdminMenuPai = this.findAdminMenuPaiByPerfil(perfilAdminPai);						
		return admMenuService.toListaMenuVO(listaAdminMenuPai);
	}
	
	/**
	 * Find menu pai by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	public List<MenuVO> findMenuPaiByPerfil(PerfilVO perfil){
		AdmPerfil perfilPai = new AdmPerfil(perfil);
		List<AdmMenu> listaMenuPai = this.findMenuPaiByPerfil(perfilPai);
		return admMenuService.toListaMenuVO(listaMenuPai);		
	}
	
	/**
	 * Find usuarios por perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	public List<AdmUsuario> findUsuariosPorPerfil(AdmPerfil perfil){
		List<AdmUsuario> lista = new ArrayList<AdmUsuario>();
		Iterable<Long> listaCod = repositorio.findUsuariosPorPerfil(perfil);
		/*
		for (Long item : listaCod) {
			lista.add(admUsuarioBC.load(item));
		}
		*/
		listaCod.forEach(item -> lista.add(admUsuarioService.load(item).get()));
		return lista;
	}
	
	/**
	 * Find menu pai by id perfis.
	 *
	 * @param listaIdPerfil the lista id perfil
	 * @return the list
	 */
	public List<AdmMenu> findMenuPaiByIdPerfis(List<Long> listaIdPerfil){
		List<AdmMenu> lista = repositorio.findMenuPaiByIdPerfis(listaIdPerfil);
		for (AdmMenu admMenu : lista) {
			admMenu.setAdmSubMenus(repositorio.findMenuByIdPerfis(listaIdPerfil, admMenu));
		}
		return lista;
	}
	
	/**
	 * Find menu pai by perfil.
	 *
	 * @param listaIdPerfil the lista id perfil
	 * @return the list
	 */
	public List<MenuVO> findMenuPaiByPerfil(List<Long> listaIdPerfil){
		List<AdmMenu> listaMenuPai = this.findMenuPaiByIdPerfis(listaIdPerfil);
		return admMenuService.toListaMenuVO(listaMenuPai);		
	}

	/**
	 * Find admin menu pai by id perfis.
	 *
	 * @param listaIdPerfil the lista id perfil
	 * @return the list
	 */
	public List<AdmMenu> findAdminMenuPaiByIdPerfis(List<Long> listaIdPerfil){
		List<AdmMenu> lista = repositorio.findAdminMenuPaiByIdPerfis(listaIdPerfil);
		for (AdmMenu admMenu : lista) {
			admMenu.setAdmSubMenus(repositorio.findAdminMenuByIdPerfis(listaIdPerfil, admMenu));
		}
		return lista;
	}
	
	/**
	 * Find admin menu pai by perfil.
	 *
	 * @param listaIdPerfil the lista id perfil
	 * @return the list
	 */
	public List<MenuVO> findAdminMenuPaiByPerfil(List<Long> listaIdPerfil){
		List<AdmMenu> listaAdminMenuPai = this.findAdminMenuPaiByIdPerfis(listaIdPerfil);						
		return admMenuService.toListaMenuVO(listaAdminMenuPai);
	}		
}
