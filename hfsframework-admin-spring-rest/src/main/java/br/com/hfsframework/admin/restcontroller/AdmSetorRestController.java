package br.com.hfsframework.admin.restcontroller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmSetor;
import br.com.hfsframework.admin.service.AdmSetorService;
import br.com.hfsframework.base.BaseRestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admSetores")
public class AdmSetorRestController 
	extends BaseRestController<AdmSetor, String, AdmSetorService> {
	
	@ApiOperation("Find AdmSetores By paiSetor")
	@GetMapping("/findBySetorPai/{paiSetor}")
	public Iterable<AdmSetor> findBySetorPai(Principal principal, @PathVariable String paiSetor){
		validateUser(principal);
		return servico.findBySetorPai(paiSetor);
	}
	
	@ApiOperation("Find Setores By paiSetor")
	@GetMapping("/findSetoresPaisBySetor/{setor}")
	public Iterable<String> findSetoresPaisBySetor(Principal principal, @PathVariable String setor){
		List<String> lista = new ArrayList<String>();
		validateUser(principal);
		servico.findSetoresPaisBySetor(setor, lista);
		
		return lista;
	}
	
	
}