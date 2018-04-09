/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.data;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hfsframework.admin.model.AdmFuncionario;

/**
 * The Interface AdmFuncionarioRepository.
 */
public interface AdmFuncionarioRepository extends JpaRepository<AdmFuncionario, Long> {

	/**
	 * Find by matricula and CPF.
	 *
	 * @param id
	 *            the id
	 * @param cpf
	 *            the cpf
	 * @return the vw adm funcionario
	 */
	@Query(name = "AdmFuncionario.findByMatriculaAndCPF")
	Optional<AdmFuncionario> findByMatriculaAndCPF(Long id, BigDecimal cpf);
}
