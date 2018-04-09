/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfsframework.admin.model.AdmCargo;

/**
 * The Interface AdmCargoRepository.
 */
public interface AdmCargoRepository extends JpaRepository<AdmCargo, Long> {

}
