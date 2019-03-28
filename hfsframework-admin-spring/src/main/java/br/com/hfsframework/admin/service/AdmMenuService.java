/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.hfsframework.admin.data.AdmMenuRepository;
import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.base.BaseBusinessService;
import br.com.hfsframework.security.model.MenuVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmMenuService.
 */
@Service
public class AdmMenuService extends BaseBusinessService<AdmMenu, Long, AdmMenuRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cache menu estaticos. */
	private static List<AdmMenu> cacheMenuEstaticos = new ArrayList<AdmMenu>();

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
	 * Salvar ou atualizar drag reordenando.
	 *
	 * @param menuPaiAntigo
	 *            the menu pai antigo
	 * @param menuPaiNovo
	 *            the menu pai novo
	 * @param menuMover
	 *            the menu mover
	 * @return the adm menu
	 */
	@Transactional
	public Optional<AdmMenu> salvarOuAtualizarDragReordenando(AdmMenu menuPaiAntigo, AdmMenu menuPaiNovo, AdmMenu menuMover) {
		cacheMenuEstaticos.clear();
		if ((menuPaiAntigo != null) && (!menuPaiAntigo.equals(menuPaiNovo))) {
			menuPaiAntigo = atualizaSubmenu(menuPaiAntigo);
		}
		if (menuPaiNovo != null) {
			menuPaiNovo = atualizaSubmenu(menuPaiNovo);
		}
		menuMover = load(menuMover.getId().longValue()).get();
		menuMover.setAdmMenuPai(menuPaiNovo);
		return update(menuMover);
	}

	/**
	 * Atualiza submenu.
	 *
	 * @param menuPai
	 *            the menu pai
	 * @return the adm menu
	 */
	@Transactional
	private AdmMenu atualizaSubmenu(AdmMenu menuPai) {
		if ((menuPai.getAdmSubMenus() != null) && (!menuPai.getAdmSubMenus().isEmpty())) {
			for (AdmMenu menu : menuPai.getAdmSubMenus()) {
				update(menu);
			}
		}
		return menuPai;
	}

	/**
	 * Salvar ou atualizar.
	 *
	 * @param novoItemMenu
	 *            the novo item menu
	 * @return the adm menu
	 */
	@Transactional
	public Optional<AdmMenu> salvarOuAtualizar(AdmMenu novoItemMenu) {
		cacheMenuEstaticos.clear();
		if ((novoItemMenu.getAdmMenuPai() != null) && (novoItemMenu.getAdmMenuPai().getId() != null)) {
			novoItemMenu.setAdmMenuPai(load(novoItemMenu.getAdmMenuPai().getId().longValue()).get());
		}
		return update(novoItemMenu);
	}

	/**
	 * Apagar.
	 *
	 * @param menu
	 *            the menu
	 */
	@Transactional
	public void apagar(AdmMenu menu) {
		cacheMenuEstaticos.clear();
		List<AdmMenu> listaMenuFilhos = repositorio.findMenusFilhos(menu);
		if ((listaMenuFilhos != null) && (!listaMenuFilhos.isEmpty())) {
			for (AdmMenu menuFilho : listaMenuFilhos) {
				apagar(menuFilho);
			}
		}
		menu = load(menu.getId().longValue()).get();
		if (menu != null) {
			delete(menu);
		}
	}

	/**
	 * To lista menu VO.
	 *
	 * @param listaMenu
	 *            the lista menu
	 * @return the list
	 */
	public List<MenuVO> toListaMenuVO(List<AdmMenu> listaMenu){
		List<MenuVO> lista = new ArrayList<MenuVO>();
		for (AdmMenu menu : listaMenu) {
			lista.add(menu.toMenuVO());
		}		
		return lista;
	}

}
