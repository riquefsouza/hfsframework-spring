/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hfsframework.admin.model.AdmParametro;

/**
 * The Interface AdmParametroRepository.
 */
public interface AdmParametroRepository extends JpaRepository<AdmParametro, Long> {

	/**
	 * Gets the descricao.
	 *
	 * @param id
	 *            the id
	 * @return the descricao
	 */
	@Query(name = "AdmParametro.getDescricaoById")
	String getDescricao(Long id);
	
	/**
	 * Count novo.
	 *
	 * @param novo
	 *            the novo
	 * @return the long
	 */
	@Query(name = "AdmParametro.countNovo")
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
	@Query(name = "AdmParametro.countAntigo")
	Long countAntigo(String antigo, String novo);
		
	/**
	 * Gets the valor by codigo.
	 *
	 * @param codigo
	 *            the codigo
	 * @return the valor by codigo
	 */
	@Query(name = "AdmParametro.getValorByCodigo")
	String getValorByCodigo(String codigo);
}
