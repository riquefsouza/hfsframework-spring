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
import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.admin.model.AdmPerfil;

/**
 * The Interface AdmFuncionalidadeRepository.
 */
public interface AdmFuncionalidadeRepository extends JpaRepository<AdmFuncionalidade, Long> {

	/**
	 * Gets the descricao.
	 *
	 * @param id
	 *            the id
	 * @return the descricao
	 */
	@Query(name = "AdmFuncionalidade.getDescricaoById")
	String getDescricao(Long id);
	
	/**
	 * Count novo.
	 *
	 * @param novo
	 *            the novo
	 * @return the long
	 */
	@Query(name = "AdmFuncionalidade.countNovo")
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
	@Query(name = "AdmFuncionalidade.countAntigo")
	Long countAntigo(String antigo, String novo);
	
	/**
	 * Find perfis por funcionalidade.
	 *
	 * @param funcionalidade
	 *            the funcionalidade
	 * @return the list
	 */
	@Query(name = "AdmFuncionalidade.findPerfisPorFuncionalidade")
	List<AdmPerfil> findPerfisPorFuncionalidade(AdmFuncionalidade funcionalidade);

	/**
	 * Find paginas por funcionalidade.
	 *
	 * @param funcionalidade
	 *            the funcionalidade
	 * @return the list
	 */
	@Query(name = "AdmFuncionalidade.findPaginasPorFuncionalidade")
	List<AdmPagina> findPaginasPorFuncionalidade(AdmFuncionalidade funcionalidade);

	/**
	 * Find menus por funcionalidade.
	 *
	 * @param funcionalidade
	 *            the funcionalidade
	 * @return the list
	 *
	@Query(name = "AdmFuncionalidade.findMenusPorFuncionalidade")
	List<AdmMenu> findMenusPorFuncionalidade(AdmFuncionalidade funcionalidade);
	*/

	/**
	 * Find perfis por URL.
	 *
	 * @param url
	 *            the url
	 * @return the list
	 */
	@Query(name = "AdmFuncionalidade.findPerfisPorURL")
	List<AdmPerfil> findPerfisPorURL(String url);
	
}
