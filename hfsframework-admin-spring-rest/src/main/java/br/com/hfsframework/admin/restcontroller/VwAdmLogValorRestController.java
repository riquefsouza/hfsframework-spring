/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.VwAdmLogValor;
import br.com.hfsframework.admin.service.VwAdmLogValorService;
import br.com.hfsframework.base.BaseRestController;

/**
 * The Class VwAdmLogValorRestController.
 */
@RestController
@RequestMapping("/vwAdmLogValores")
public class VwAdmLogValorRestController 
	extends BaseRestController<VwAdmLogValor, Long, VwAdmLogValorService> {

}
