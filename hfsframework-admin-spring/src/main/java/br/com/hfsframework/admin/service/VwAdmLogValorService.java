/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import org.springframework.stereotype.Service;

import br.com.hfsframework.admin.data.VwAdmLogValorRepository;
import br.com.hfsframework.admin.model.VwAdmLogValor;
import br.com.hfsframework.base.BaseBusinessService;

/**
 * The Class VwAdmLogValorBC.
 */
@Service
public class VwAdmLogValorService extends BaseBusinessService<VwAdmLogValor, Long, VwAdmLogValorRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

}
