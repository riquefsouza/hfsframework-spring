/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmLogColuna;
import br.com.hfsframework.admin.service.AdmLogColunaService;
import br.com.hfsframework.base.BaseRestController;

/**
 * The Class AdmLogColunaRestController.
 */
@RestController
@RequestMapping("/admLogColunas")
public class AdmLogColunaRestController 
	extends BaseRestController<AdmLogColuna, String, AdmLogColunaService> {
}
