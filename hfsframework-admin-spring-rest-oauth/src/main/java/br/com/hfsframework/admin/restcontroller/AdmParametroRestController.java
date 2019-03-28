/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.restcontroller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmParametro;
import br.com.hfsframework.admin.service.AdmParametroService;
import br.com.hfsframework.base.BaseRestController;
import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmParametroRestController.
 */
@RestController
@RequestMapping("/admParametros")
public class AdmParametroRestController extends BaseRestController<AdmParametro, Long, AdmParametroService> {

	/**
	 * Gets the valor by codigo.
	 *
	 * @param principal the principal
	 * @param codigo the codigo
	 * @return the valor by codigo
	 */
	@ApiOperation("Get Valor Parametro By codigo")
	@GetMapping("/getValorByCodigo/{codigo}")
	public String getValorByCodigo(Principal principal, @PathVariable String codigo) {
		validateUser(principal);
		
		return servico.getValorByCodigo(codigo);
	}
}
