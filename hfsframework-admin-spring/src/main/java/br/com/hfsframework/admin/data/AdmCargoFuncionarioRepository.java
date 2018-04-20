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

import br.com.hfsframework.admin.model.AdmCargoFuncionario;
import br.com.hfsframework.admin.model.AdmCargoFuncionarioPK;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdmCargoFuncionarioRepository.
 */
public interface AdmCargoFuncionarioRepository extends JpaRepository<AdmCargoFuncionario, AdmCargoFuncionarioPK> {

	/**
	 * Find cargo by cod funcionario.
	 *
	 * @param codFuncionario
	 *            the cod funcionario
	 * @return the list
	 */
	@Query(name = "AdmCargoFuncionario.findCargoByCodFuncionario")
	List<Long> findCargoByCodFuncionario(Long codFuncionario);
	
	/**
	 * Find funcionario by cod cargo.
	 *
	 * @param codCargo
	 *            the cod cargo
	 * @return the list
	 */
	@Query(name = "AdmCargoFuncionario.findFuncionarioByCodCargo")
	List<Long> findFuncionarioByCodCargo(Long codCargo);
	
}
