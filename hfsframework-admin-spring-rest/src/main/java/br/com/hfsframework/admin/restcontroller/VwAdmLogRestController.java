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

import br.com.hfsframework.admin.model.VwAdmLog;
import br.com.hfsframework.admin.service.VwAdmLogService;
import br.com.hfsframework.base.BaseRestController;
import br.com.hfsframework.util.DataUtil;
import io.swagger.annotations.ApiOperation;

/**
 * The Class VwAdmLogRestController.
 */
@RestController
@RequestMapping("/vwAdmLogs")
public class VwAdmLogRestController 
	extends BaseRestController<VwAdmLog, Long, VwAdmLogService> {
	
	//http://localhost:8080/vwAdmLogs/findByFiltros?entidade=123&chave=123&usuario=123&ip=123&operacao=123&datainicial=123&datafinal=123	
	@ApiOperation("Find By Filtros")
	@GetMapping(value="/findByFiltros", params = {"entidade", "chave", "usuario", "ip", "operacao", "datainicial", "datafinal"})
	public List<VwAdmLog> findByFiltros(Principal principal, 
			@RequestParam("entidade") String entidade, 
			@RequestParam("chave") String chave,
			@RequestParam("usuario") String usuario,
			@RequestParam("ip") String ip,
			@RequestParam("operacao") String operacao,
			@RequestParam("datainicial") String datainicial,  
			@RequestParam("datafinal") String datafinal) {
		validateUser(principal);
		
		VwAdmLog filtros = new VwAdmLog();
		filtros.setEntidade(entidade);
		filtros.setChave(chave);
		filtros.setUsuario(usuario);
		filtros.setIp(ip);
		filtros.setOperacao(operacao);		
		if (!datainicial.isEmpty()){
			filtros.setDataInicio(DataUtil.toDate(datainicial, DataUtil.DATA_PADRAO));
		}
		if (!datafinal.isEmpty()){
			filtros.setDataFim(DataUtil.toDate(datafinal, DataUtil.DATA_PADRAO));
		}
		
		return servico.findByFiltros(filtros);
	}
	
}
