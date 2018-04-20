/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hfsframework.admin.model.AdmFuncionalidade;
import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.admin.model.AdmPagina;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdmMenuRepository.
 */
public interface AdmMenuRepository extends JpaRepository<AdmMenu, Long> {

	/**
	 * Gets the descricao.
	 *
	 * @param id
	 *            the id
	 * @return the descricao
	 */
	@Query(name = "AdmMenu.getDescricaoById")
	String getDescricao(Long id);
	
	/**
	 * Count novo.
	 *
	 * @param novo
	 *            the novo
	 * @return the long
	 */
	@Query(name = "AdmMenu.countNovo")
	Long countNovo(String novo);

	/**
	 * Count antigo novo.
	 *
	 * @param antigo
	 *            the antigo
	 * @param novo
	 *            the novo
	 * @return the long
	 */
	@Query(name = "AdmMenu.countAntigo")
	Long countAntigo(String antigo, String novo);
	
	/**
	 * Find menu raiz.
	 *
	 * @return the list
	 */
	@Query(name="AdmMenu.findMenuRaiz")
	List<AdmMenu> findMenuRaiz();
	
	/**
	 * Find menu raiz.
	 *
	 * @param nomeItemMenu
	 *            the nome item menu
	 * @return the list
	 */
	@Query(name="AdmMenu.findMenuRaizByDescricao")
	List<AdmMenu> findMenuRaiz(String nomeItemMenu);
	
	/**
	 * Count menu by funcionalidade.
	 *
	 * @param funcionalidade
	 *            the funcionalidade
	 * @return the integer
	 */
	@Query(name="AdmMenu.countMenuByFuncionalidade")
	Integer countMenuByFuncionalidade(AdmFuncionalidade funcionalidade);
	
	/**
	 * Find menus filhos.
	 *
	 * @param menu
	 *            the menu
	 * @return the list
	 */
	@Query(name="AdmMenu.findMenusFilhos")
	List<AdmMenu> findMenusFilhos(AdmMenu menu);
	
	/**
	 * Find admin menu pai by cod funcionario.
	 *
	 * @param funcionalidade
	 *            the funcionalidade
	 * @return the list
	 */
	@Query(name="AdmMenu.findAdminMenuPaiByFuncionalidade")
	List<AdmMenu> findAdminMenuPaiByCodFuncionario(AdmFuncionalidade funcionalidade);

	/**
	 * Find menu pai by cod funcionario.
	 *
	 * @param funcionalidade
	 *            the funcionalidade
	 * @return the list
	 */
	@Query(name="AdmMenu.findMenuPaiByFuncionalidade")
	List<AdmMenu> findMenuPaiByCodFuncionario(AdmFuncionalidade funcionalidade);
	
	/**
	 * Find pagina by menu.
	 *
	 * @param funcionalidade
	 *            the funcionalidade
	 * @param idMenu
	 *            the id menu
	 * @return the adm pagina
	 */
	@Query(name="AdmMenu.findPaginaByMenu")
	AdmPagina findPaginaByMenu(AdmFuncionalidade funcionalidade, Long idMenu);
	
	/*
	 * Find funcionarios por menu.
	 *
	 * @param menu
	 *            the menu
	 * @return the list
	 */
	//@Query(name = "AdmMenu.findFuncionariosPorMenu")
	//List<AdmFuncionarioDTO> findFuncionariosPorMenu(AdmMenu menu);
	
}
