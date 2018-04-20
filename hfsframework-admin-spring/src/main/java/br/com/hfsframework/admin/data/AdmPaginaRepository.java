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

// TODO: Auto-generated Javadoc
/**
 * The Interface AdmPaginaRepository.
 */
public interface AdmPaginaRepository extends JpaRepository<AdmPagina, Long> {

	/**
	 * Gets the descricao.
	 *
	 * @param id
	 *            the id
	 * @return the descricao
	 */
	@Query(name = "AdmPagina.getDescricaoById")
	String getDescricao(Long id);
	
	/**
	 * Count novo.
	 *
	 * @param novo
	 *            the novo
	 * @return the long
	 */
	@Query(name = "AdmPagina.countNovo")
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
	@Query(name = "AdmPagina.countAntigo")
	Long countAntigo(String antigo, String novo);
	
	/**
	 * Find perfis por pagina.
	 *
	 * @param pagina
	 *            the pagina
	 * @return the list
	 */
	@Query(name = "AdmPagina.findPerfisPorPagina")
	List<AdmPerfil> findPerfisPorPagina(AdmPagina pagina);

	/**
	 * Find funcionalidades por pagina.
	 *
	 * @param pagina
	 *            the pagina
	 * @return the list
	 */
	@Query(name = "AdmPagina.findFuncionalidadesPorPagina")
	List<AdmFuncionalidade> findFuncionalidadesPorPagina(AdmPagina pagina);

}
