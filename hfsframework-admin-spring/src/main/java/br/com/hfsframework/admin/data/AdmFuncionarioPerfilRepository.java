/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hfsframework.admin.model.AdmFuncionarioPerfil;
import br.com.hfsframework.admin.model.AdmFuncionarioPerfilPK;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdmFuncionarioPerfilRepository.
 */
public interface AdmFuncionarioPerfilRepository extends JpaRepository<AdmFuncionarioPerfil, AdmFuncionarioPerfilPK> {

	/**
	 * Delete by perfil.
	 *
	 * @param perfilSeq
	 *            the perfil seq
	 */
	@Query(name = "AdmFuncionarioPerfil.deleteByPerfil")
	void deleteByPerfil(Long perfilSeq);
	
	/**
	 * Delete by cod funcionario.
	 *
	 * @param codFuncionario
	 *            the cod funcionario
	 */
	@Query(name = "AdmFuncionarioPerfil.deleteByCodFuncionario")
	void deleteByCodFuncionario(Long codFuncionario);
}
