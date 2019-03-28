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

// TODO: Auto-generated Javadoc
/**
 * The Interface VwAdmLogRepository.
 */
public interface VwAdmLogRepository extends JpaRepository<VwAdmLog, Long> {

	/**
	 * Find entidades.
	 *
	 * @return the list
	 */
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
	List<VwAdmLog> findByFiltros(String entidade, String usuario, 
			String ip, String operacao, String chave,
			Long dataInicio, Long dataFim);
	
}
