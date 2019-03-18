/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.hfsframework.admin.model.AdmUsuarioIp;
import br.com.hfsframework.admin.model.AdmUsuarioIpPK;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdmUsuarioIpRepository.
 */
public interface AdmUsuarioIpRepository extends JpaRepository<AdmUsuarioIp, AdmUsuarioIpPK> {

	/**
	 * Update ativo by id.
	 *
	 * @param ativo the ativo
	 * @param idUsuario the idUsuario
	 * @param ip the ip
	 * @return the int
	 */
	@Modifying
	@Query("UPDATE AdmUsuarioIp as u SET u.ativo=?1 WHERE u.id.usuarioSeq=?2 AND u.id.ip = ?3")
	int updateAtivoById(Boolean ativo, Long idUsuario, String ip);
	
	/**
	 * Update ativo by idUsuario.
	 *
	 * @param ativo the ativo
	 * @param idUsuario the idUsuario
	 * @return the int
	 */
	@Modifying
	@Query("UPDATE AdmUsuarioIp as u SET u.ativo=?1 WHERE u.id.usuarioSeq=?2")
	int updateAtivoByIdUsuario(Boolean ativo, Long idUsuario);
}
