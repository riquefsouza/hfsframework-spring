/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.hfsframework.admin.data.AdmUsuarioPerfilRepository;
import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.model.AdmUsuarioPerfil;
import br.com.hfsframework.admin.model.AdmUsuarioPerfilPK;
import br.com.hfsframework.base.BaseBusinessService;
import br.com.hfsframework.util.exceptions.TransacaoException;

@Service
public class AdmUsuarioPerfilService
		extends BaseBusinessService<AdmUsuarioPerfil, AdmUsuarioPerfilPK, AdmUsuarioPerfilRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Delete by perfil.
	 *
	 * @param perfilSeq the perfil seq
	 * @throws TransacaoException the transacao exception
	 */
	@Transactional
	public void deleteByPerfil(Long perfilSeq) throws TransacaoException {
		try {
			repositorio.deleteByPerfil(perfilSeq);
		} catch (Exception e) {
			throw new TransacaoException(log, ERRO_DELETE + e.getMessage(), e);
		}
	}

	/**
	 * Delete by usuarios.
	 *
	 * @param usuarios
	 *            the usuarios
	 * @throws TransacaoException
	 *             the transacao exception
	 */
	@Transactional
	public void deleteByUsuarios(List<AdmUsuario> usuarios) throws TransacaoException {
		try {
			for (AdmUsuario usuario : usuarios) {
				repositorio.deleteByCodUsuario(usuario.getId());
			}
		} catch (Exception e) {
			throw new TransacaoException(log, ERRO_DELETE + e.getMessage(), e);
		}
	}

	
}
