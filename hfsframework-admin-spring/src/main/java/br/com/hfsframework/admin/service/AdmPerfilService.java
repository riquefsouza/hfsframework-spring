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
import br.com.hfsframework.admin.model.AdmCargo;
import br.com.hfsframework.admin.model.AdmCargoPerfil;
import br.com.hfsframework.admin.model.AdmCargoPerfilPK;
import br.com.hfsframework.admin.model.AdmFuncionalidade;
import br.com.hfsframework.admin.model.AdmFuncionario;
import br.com.hfsframework.admin.model.AdmFuncionarioPerfil;
import br.com.hfsframework.admin.model.AdmFuncionarioPerfilPK;
import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.base.BaseBusinessService;
import br.com.hfsframework.security.model.MenuVO;
import br.com.hfsframework.security.model.PerfilVO;
import br.com.hfsframework.security.model.PermissaoVO;
import br.com.hfsframework.util.exceptions.TransacaoException;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmPerfilBC.
 */
@Service
public class AdmPerfilService extends BaseBusinessService<AdmPerfil, Long, AdmPerfilRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The adm menu BC. */
	@Autowired
	private AdmMenuService admMenuService;
	
	/** The adm funcionario BC. */
	@Autowired
	private AdmFuncionarioService admFuncionarioService;
	
	/** The adm cargo BC. */
	@Autowired
	private AdmCargoService admCargoService;
	
	/** The adm funcionario perfil service. */
	/* The adm funcionario perfil BC. */
	@Autowired
	private AdmFuncionarioPerfilService admFuncionarioPerfilService;

	/** The adm cargo perfil BC. */
	@Autowired
	private AdmCargoPerfilService admCargoPerfilService;

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#load(java.io.Serializable)
	 */
	@Override
	public Optional<AdmPerfil> load(Long id) {
		Optional<AdmPerfil> item = this.load(id);
		item.get().setAdmFuncionarios(this.findFuncionariosPorPerfil(item.get()));
		item.get().setAdmCargos(this.findCargosPorPerfil(item.get()));
		return item;
	}
	
	/**
	 * Atribui o adm funcionario cargo.
	 *
	 * @param lista
	 *            the lista
	 * @return the list
	 */
	private Iterable<AdmPerfil> setAdmFuncionarioCargo(Iterable<AdmPerfil> lista) {
		for (AdmPerfil item : lista) {
			item.setAdmFuncionarios(this.findFuncionariosPorPerfil(item));
			item.setAdmCargos(this.findCargosPorPerfil(item));
		}
		
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#findAll()
	 */
	@Override
	public Iterable<AdmPerfil> findAll() {
		Iterable<AdmPerfil> lista = super.findAll();		
		return setAdmFuncionarioCargo(lista);
	}
	
	/**
	 * Atribui o cargos funcionarios.
	 *
	 * @param bean
	 *            the bean
	 */
	private void setCargosFuncionarios(Optional<AdmPerfil> bean) {
		AdmCargoPerfil admCargoPerfil; 
		AdmCargoPerfilPK admCargoPerfilPK;
		
		for (AdmCargo cargo : bean.get().getAdmCargos()) {

			admCargoPerfilPK = new AdmCargoPerfilPK();
			admCargoPerfilPK.setPerfilSeq(bean.get().getId());
			admCargoPerfilPK.setCodCargo(cargo.getId());
			
			admCargoPerfil = new AdmCargoPerfil();
			admCargoPerfil.setId(admCargoPerfilPK);
			admCargoPerfil.setAdmPerfil(bean.get());
			
			admCargoPerfilService.insert(admCargoPerfil);
		}

		AdmFuncionarioPerfil admFuncionarioPerfil; 
		AdmFuncionarioPerfilPK admFuncionarioPerfilPK;

		for (AdmFuncionario funcionario : bean.get().getAdmFuncionarios()) {
			
			admFuncionarioPerfilPK = new AdmFuncionarioPerfilPK();
			admFuncionarioPerfilPK.setPerfilSeq(bean.get().getId());
			admFuncionarioPerfilPK.setCodFuncionario(funcionario.getId());
			
			admFuncionarioPerfil = new AdmFuncionarioPerfil();
			admFuncionarioPerfil.setId(admFuncionarioPerfilPK);
			admFuncionarioPerfil.setAdmPerfil(bean.get());
			
			admFuncionarioPerfilService.insert(admFuncionarioPerfil);
		}
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#delete(java.lang.Object)
	 */
	@Override
	@Transactional
	public void delete(AdmPerfil bean) throws TransacaoException {
		super.delete(bean);		
		admCargoPerfilService.deleteByPerfil(bean.getId());
		admFuncionarioPerfilService.deleteByPerfil(bean.getId());
	}


	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#insert(java.lang.Object)
	 */
	@Override
	@Transactional
	public Optional<AdmPerfil> insert(AdmPerfil bean) throws TransacaoException {
		Optional<AdmPerfil> novo = super.insert(bean);
		if (novo.isPresent()) {
			setCargosFuncionarios(novo);
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

		admCargoPerfilService.deleteByPerfil(bean.getId());
		admFuncionarioPerfilService.deleteByPerfil(bean.getId());
		
		//admCargoPerfilBC.deleteByCargos(bean.getAdmCargos());
		admFuncionarioPerfilService.deleteByFuncionarios(bean.getAdmFuncionarios());
		
		setCargosFuncionarios(Optional.of(bean));
		
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
	 * @param idAdmFuncionario the id adm funcionario
	 * @return the papeis
	 */
	public HashSet<AdmPerfil> getPapeis(Long idAdmFuncionario) {
		HashSet<AdmPerfil> hs = new HashSet<AdmPerfil>();

		//AdmFuncionario admFuncionario = new AdmFuncionario(usuarioAutenticado.getFuncionario());		
		Iterable<AdmPerfil> lst = repositorio.findPerfisPorFuncionario(idAdmFuncionario);		
		lst = setAdmFuncionarioCargo(lst);
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

	/**
	 * Gets the permissao.
	 *
	 * @param idAdmFuncionario the id adm funcionario
	 * @return the permissao
	 */
	public List<PermissaoVO> getPermissao(Long idAdmFuncionario) {
		List<PermissaoVO> lista = new ArrayList<PermissaoVO>();
		PermissaoVO permissao;
		List<AdmPagina> paginasFuncionalidade;
		
		//AdmFuncionario admFuncionario = new AdmFuncionario(usuarioAutenticado.getFuncionario());
		Iterable<AdmPerfil> perfis = repositorio.findPerfisPorFuncionario(idAdmFuncionario);
		perfis = setAdmFuncionarioCargo(perfis);
		
		for (AdmPerfil perfil : perfis) {
			permissao = new PermissaoVO();
			permissao.setPerfil(perfil.toPerfilVO());

			for (AdmFuncionalidade admFuncionalidade : perfil.getAdmFuncionalidades()) {
				permissao.getFuncionalidades().add(admFuncionalidade.toFuncionalidadeVO());	
			}
			
			paginasFuncionalidade = new ArrayList<AdmPagina>();
			for (AdmFuncionalidade admFuncionalidade : perfil.getAdmFuncionalidades()) {
				paginasFuncionalidade.add(admFuncionalidade.getAdmPaginaInicial());	
			}
			
			for (AdmPagina admPaginaFunc : paginasFuncionalidade) {
				permissao.getPaginasFuncionalidade().add(admPaginaFunc.toPaginaVO());	
			}
			
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
	 * Find funcionarios por perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	public List<AdmFuncionario> findFuncionariosPorPerfil(AdmPerfil perfil){
		List<AdmFuncionario> lista = new ArrayList<AdmFuncionario>();
		Iterable<Long> listaCod = repositorio.findFuncionariosPorPerfil(perfil);
		/*
		for (Long item : listaCod) {
			lista.add(admFuncionarioBC.load(item));
		}
		*/
		listaCod.forEach(item -> lista.add(admFuncionarioService.load(item).get()));
		return lista;
	}
	
	/**
	 * Find cargos por perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	public List<AdmCargo> findCargosPorPerfil(AdmPerfil perfil){
		List<AdmCargo> lista = new ArrayList<AdmCargo>();
		Iterable<Long> listaCod = repositorio.findCargosPorPerfil(perfil);
		/*
		for (Long item : listaCod) {
			lista.add(admCargoBC.load(item));
		}
		*/
		listaCod.forEach(item -> lista.add(admCargoService.load(item).get()));
		return lista;
	}
}
