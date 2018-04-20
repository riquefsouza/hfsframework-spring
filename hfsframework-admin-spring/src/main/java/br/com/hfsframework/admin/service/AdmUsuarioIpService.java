/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.hfsframework.admin.data.AdmUsuarioIpRepository;
import br.com.hfsframework.admin.model.AdmUsuarioIp;
import br.com.hfsframework.admin.model.AdmUsuarioIpPK;
import br.com.hfsframework.base.BaseBusinessService;
import br.com.hfsframework.util.exceptions.TransacaoException;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmUsuarioIpService.
 */
@Service
public class AdmUsuarioIpService extends BaseBusinessService<AdmUsuarioIp, AdmUsuarioIpPK, AdmUsuarioIpRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Update ativo by id.
	 *
	 * @param ativo the ativo
	 * @param id the id
	 * @return the int
	 * @throws TransacaoException the transacao exception
	 */
	@Transactional
	public int updateAtivoById(Boolean ativo, AdmUsuarioIpPK id) throws TransacaoException {
		try {
			return repositorio.updateAtivoById(ativo, id.getMatricula(), id.getIp());
		} catch (Exception e) {
			throw new TransacaoException(log, ERRO_UPDATE + e.getMessage(), e);
		}
	}
	
	/**
	 * Update ativo by matricula.
	 *
	 * @param ativo the ativo
	 * @param matricula the matricula
	 * @return the int
	 * @throws TransacaoException the transacao exception
	 */
	@Transactional
	public int updateAtivoByMatricula(Boolean ativo, Long matricula) throws TransacaoException {
		try {
			return repositorio.updateAtivoByMatricula(ativo, matricula);
		} catch (Exception e) {
			throw new TransacaoException(log, ERRO_UPDATE + e.getMessage(), e);
		}
	}	
}
