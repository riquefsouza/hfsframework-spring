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

import br.com.hfsframework.admin.data.AdmFuncionarioPerfilRepository;
import br.com.hfsframework.admin.model.AdmFuncionario;
import br.com.hfsframework.admin.model.AdmFuncionarioPerfil;
import br.com.hfsframework.admin.model.AdmFuncionarioPerfilPK;
import br.com.hfsframework.base.BaseBusinessService;
import br.com.hfsframework.util.exceptions.TransacaoException;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmFuncionarioPerfilBC.
 */
@Service
public class AdmFuncionarioPerfilService
		extends BaseBusinessService<AdmFuncionarioPerfil, AdmFuncionarioPerfilPK, AdmFuncionarioPerfilRepository> {

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
	 * Delete by funcionarios.
	 *
	 * @param funcionarios
	 *            the funcionarios
	 * @throws TransacaoException
	 *             the transacao exception
	 */
	@Transactional
	public void deleteByFuncionarios(List<AdmFuncionario> funcionarios) throws TransacaoException {
		try {
			for (AdmFuncionario funcionario : funcionarios) {
				repositorio.deleteByCodFuncionario(funcionario.getId());
			}
		} catch (Exception e) {
			throw new TransacaoException(log, ERRO_DELETE + e.getMessage(), e);
		}
	}
	
}
