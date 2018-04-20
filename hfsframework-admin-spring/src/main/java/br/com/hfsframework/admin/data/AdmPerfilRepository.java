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
import br.com.hfsframework.admin.model.AdmPerfil;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdmPerfilRepository.
 */
public interface AdmPerfilRepository extends JpaRepository<AdmPerfil, Long> {

	/**
	 * Gets the descricao.
	 *
	 * @param id
	 *            the id
	 * @return the descricao
	 */
	@Query(name = "AdmPerfil.getDescricaoById")
	String getDescricao(Long id);
	
	/**
	 * Count novo.
	 *
	 * @param novo
	 *            the novo
	 * @return the long
	 */
	@Query(name = "AdmPerfil.countNovo")
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
	@Query(name = "AdmPerfil.countAntigo")
	Long countAntigo(String antigo, String novo);
	
	/**
	 * Find cargos por perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	@Query(name = "AdmPerfil.findCargosPorPerfil")
	Iterable<Long> findCargosPorPerfil(AdmPerfil perfil);

	/**
	 * Find paginas por perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	@Query(name = "AdmPerfil.findPaginasPorPerfil")
	List<AdmPagina> findPaginasPorPerfil(AdmPerfil perfil);

	/**
	 * Find funcionarios por perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	@Query(name = "AdmPerfil.findFuncionariosPorPerfil")
	Iterable<Long> findFuncionariosPorPerfil(AdmPerfil perfil);

	/**
	 * Find funcionalidades por perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	@Query(name = "AdmPerfil.findFuncionalidadesPorPerfil")
	List<AdmFuncionalidade> findFuncionalidadesPorPerfil(AdmPerfil perfil);
	
	/**
	 * Find perfis por funcionario.
	 *
	 * @param idFuncionario
	 *            the id funcionario
	 * @return the list
	 */
	@Query(name = "AdmPerfil.findPerfisPorFuncionario")	
	Iterable<AdmPerfil> findPerfisPorFuncionario(Long idFuncionario);
	
	/**
	 * Find admin menu pai by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	@Query(name="AdmPerfil.findAdminMenuPaiByPerfil")
	List<AdmMenu> findAdminMenuPaiByPerfil(AdmPerfil perfil);

	/**
	 * Find menu pai by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	@Query(name="AdmPerfil.findMenuPaiByPerfil")
	List<AdmMenu> findMenuPaiByPerfil(AdmPerfil perfil);

	/**
	 * Find admin menu by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @param menuPai
	 *            the menu pai
	 * @return the list
	 */
	@Query(name="AdmPerfil.findAdminMenuByPerfil")
	List<AdmMenu> findAdminMenuByPerfil(AdmPerfil perfil, AdmMenu menuPai);
	
	/**
	 * Find menu by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @param menuPai
	 *            the menu pai
	 * @return the list
	 */
	@Query(name="AdmPerfil.findMenuByPerfil")
	List<AdmMenu> findMenuByPerfil(AdmPerfil perfil, AdmMenu menuPai);
}
