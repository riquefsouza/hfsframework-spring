/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class AdmSetorRestController.
 */
@RestController
@RequestMapping("/admSetores")
public class AdmSetorRestController 
	extends BaseRestController<AdmSetor, String, AdmSetorService> {
	
	/**
	 * Find by setor pai.
	 *
	 * @param principal the principal
	 * @param paiSetor the pai setor
	 * @return the iterable
	 */
	@ApiOperation("Find AdmSetores By paiSetor")
	@GetMapping("/findBySetorPai/{paiSetor}")
	public Iterable<AdmSetor> findBySetorPai(Principal principal, @PathVariable String paiSetor){
		validateUser(principal);
		return servico.findBySetorPai(paiSetor);
	}
	
	/**
	 * Find setores pais by setor.
	 *
	 * @param principal the principal
	 * @param setor the setor
	 * @return the iterable
	 */
	@ApiOperation("Find Setores By paiSetor")
	@GetMapping("/findSetoresPaisBySetor/{setor}")
	public Iterable<String> findSetoresPaisBySetor(Principal principal, @PathVariable String setor){
		List<String> lista = new ArrayList<String>();
		validateUser(principal);
		servico.findSetoresPaisBySetor(setor, lista);
		
		return lista;
	}
	
	
}
