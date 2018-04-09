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

import br.com.hfsframework.admin.model.AdmSetor;

/**
 * The Interface AdmSetorRepository.
 */
public interface AdmSetorRepository extends JpaRepository<AdmSetor, String> {

	/**
	 * Find by setor pai.
	 *
	 * @param paiSetor
	 *            the pai setor
	 * @return the list
	 */
	@Query(name = "AdmSetor.findBySetorPai")
	List<AdmSetor> findBySetorPai(String paiSetor);
}
