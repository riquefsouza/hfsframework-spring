package br.com.hfsframework.admin.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmParametro;
import br.com.hfsframework.admin.service.AdmParametroService;
import br.com.hfsframework.base.BaseRestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admParametros")
public class AdmParametroRestController extends BaseRestController<AdmParametro, Long, AdmParametroService> {

	@ApiOperation("Get Valor Parametro By codigo")
	@GetMapping("/getValorByCodigo/{codigo}")
	public String getValorByCodigo(@PathVariable String codigo) {
		return servico.getValorByCodigo(codigo);
	}
}
