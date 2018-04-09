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

import br.com.hfsframework.admin.model.VwAdmLog;

/**
 * The Interface VwAdmLogRepository.
 */
public interface VwAdmLogRepository extends JpaRepository<VwAdmLog, Long> {

	@Query(name = "VwAdmLog.findEntidades")
	List<String> findEntidades();

	/**
	 * Find by filtros.
	 *
	 * @param entidade
	 *            the entidade
	 * @param usuario
	 *            the usuario
	 * @param ip
	 *            the ip
	 * @param operacao
	 *            the operacao
	 * @param chave
	 *            the chave
	 * @param dataInicio
	 *            the data inicio
	 * @param dataFim
	 *            the data fim
	 * @return the list
	 */
	@Query(name = "VwAdmLog.findByFiltros")
	List<VwAdmLog> findByFiltros(String entidade, String usuario, String ip, String operacao, String chave,
			Long dataInicio, Long dataFim);

	/**
	 * Checa se é contem chave.
	 *
	 * @param tabela
	 *            the tabela
	 * @param id
	 *            the id
	 * @param chave
	 *            the chave
	 * @param valor
	 *            the valor
	 * @return the object
	 */
	@Query(name = "VwAdmLog.isContemChave" , nativeQuery = true)
	Object isContemChave(String tabela, long id, String chave, String valor);

	/**
	 * Detalhar.
	 *
	 * @param tabela
	 *            the tabela
	 * @param id
	 *            the id
	 * @return the list
	 */
	@Query(name = "VwAdmLog.detalhar" , nativeQuery = true)
	List<Object> detalhar(String tabela, String id);

	/**
	 * Primary keys.
	 *
	 * @param tabela
	 *            the tabela
	 * @return the list
	 */
	@Query(name = "VwAdmLog.primaryKeys" , nativeQuery = true)
	List<Object> primaryKeys(String tabela);
	
	
}
