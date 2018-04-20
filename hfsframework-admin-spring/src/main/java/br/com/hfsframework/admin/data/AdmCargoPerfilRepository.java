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

import br.com.hfsframework.admin.model.AdmCargoPerfil;
import br.com.hfsframework.admin.model.AdmCargoPerfilPK;
import br.com.hfsframework.admin.model.AdmPerfil;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdmCargoPerfilRepository.
 */
public interface AdmCargoPerfilRepository extends JpaRepository<AdmCargoPerfil, AdmCargoPerfilPK> {

	/**
	 * Find perfil by cod cargo.
	 *
	 * @param codCargo
	 *            the cod cargo
	 * @return the list
	 */
	@Query(name = "AdmCargoPerfil.findPerfilByCodCargo")
	List<AdmPerfil> findPerfilByCodCargo(Long codCargo);
	
	/**
	 * Delete by perfil.
	 *
	 * @param perfilSeq
	 *            the perfil seq
	 */
	@Query(name = "AdmCargoPerfil.deleteByPerfil")
	void deleteByPerfil(Long perfilSeq);

	/**
	 * Delete by cod cargo.
	 *
	 * @param codCargo
	 *            the cod cargo
	 */
	@Query(name = "AdmCargoPerfil.deleteByCodCargo")
	void deleteByCodCargo(Long codCargo);

}
