/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.admin.service.AdmPaginaService;
import br.com.hfsframework.base.BaseRestController;

/**
 * The Class AdmPaginaRestController.
 */
@RestController
@RequestMapping("/admPaginas")
public class AdmPaginaRestController 
	extends BaseRestController<AdmPagina, Long, AdmPaginaService> {
}
