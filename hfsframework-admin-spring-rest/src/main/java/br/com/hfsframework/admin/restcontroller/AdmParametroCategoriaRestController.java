/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.admin.service.AdmParametroCategoriaService;
import br.com.hfsframework.base.BaseRestController;

/**
 * The Class AdmParametroCategoriaRestController.
 */
@RestController
@RequestMapping("/admParametroCategorias")
public class AdmParametroCategoriaRestController
		extends BaseRestController<AdmParametroCategoria, Long, AdmParametroCategoriaService> {

}
