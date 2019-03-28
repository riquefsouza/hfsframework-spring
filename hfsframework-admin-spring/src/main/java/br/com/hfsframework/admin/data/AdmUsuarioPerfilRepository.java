/**
 * @author Henrique Figueiredo de Souza
 * @version 1.0.2
 * @since 2019
 */
package br.com.hfsframework.admin.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hfsframework.admin.model.AdmUsuarioPerfil;
import br.com.hfsframework.admin.model.AdmUsuarioPerfilPK;

public interface AdmUsuarioPerfilRepository extends JpaRepository<AdmUsuarioPerfil, AdmUsuarioPerfilPK> {

	/**
	 * Delete by perfil.
	 *
	 * @param perfilSeq
	 *            the perfil seq
	 */
	@Query(name = "AdmUsuarioPerfil.deleteByPerfil")
	void deleteByPerfil(Long perfilSeq);

	/**
	 * Delete by cod funcionario.
	 *
	 * @param codUsuario
	 *            the cod funcionario
	 */
	@Query(name = "AdmUsuarioPerfil.deleteByCodUsuario")
	void deleteByCodUsuario(Long codUsuario);
}
