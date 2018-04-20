/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hfsframework.admin.model.AdmParametroCategoria;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdmParametroCategoriaRepository.
 */
public interface AdmParametroCategoriaRepository extends JpaRepository<AdmParametroCategoria, Long> {

	/**
	 * Gets the descricao.
	 *
	 * @param id
	 *            the id
	 * @return the descricao
	 */
	@Query(name = "AdmParametroCategoria.getDescricaoById")
	String getDescricao(Long id);
	
	/**
	 * Count novo.
	 *
	 * @param novo
	 *            the novo
	 * @return the long
	 */
	@Query(name = "AdmParametroCategoria.countNovo")
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
	@Query(name = "AdmParametroCategoria.countAntigo")
	Long countAntigo(String antigo, String novo);
	
}
