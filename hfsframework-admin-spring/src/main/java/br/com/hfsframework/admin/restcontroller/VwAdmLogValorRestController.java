/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.restcontroller;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.VwAdmLogValor;
import br.com.hfsframework.admin.service.VwAdmLogValorService;
import br.com.hfsframework.base.BaseRestController;
import io.swagger.annotations.ApiOperation;

/**
 * The Class VwAdmLogValorRestController.
 */
@RestController
@RequestMapping("/vwAdmLogValores")
public class VwAdmLogValorRestController 
	extends BaseRestController<VwAdmLogValor, Long, VwAdmLogValorService> {

	//http://localhost:8080/vwAdmLogValores/findByFiltros?usuario=123&dataNumero=123&operacao=123&ip=123&entidade=123&tabela=123&chave=123
	@ApiOperation("Find By Filtros")
	@GetMapping(value="/findByFiltros", params = {"usuario", "dataNumero", "operacao", "ip", "entidade", "tabela", "chave"})
	public List<VwAdmLogValor> findByFiltros(Principal principal, @RequestParam("usuario") String usuario, 
			@RequestParam("dataNumero") Long dataNumero, @RequestParam("operacao") String operacao, @RequestParam("ip") String ip,
			@RequestParam("entidade") String entidade, @RequestParam("tabela") String tabela, @RequestParam("chave") String chave) {
		validateUser(principal);
		
		return servico.findByFiltros(usuario, dataNumero, operacao, ip, entidade, tabela, chave);
	}
	
}
