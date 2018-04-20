/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.restcontroller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmFuncionario;
import br.com.hfsframework.admin.service.AdmFuncionarioPerfilService;
import br.com.hfsframework.admin.service.AdmFuncionarioService;
import br.com.hfsframework.base.BaseRestController;
import br.com.hfsframework.util.exceptions.TransacaoException;
import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmFuncionarioRestController.
 */
@RestController
@RequestMapping("/admFuncionarios")
public class AdmFuncionarioRestController extends BaseRestController<AdmFuncionario, Long, AdmFuncionarioService> {

	/** The adm funcionario perfil service. */
	@Autowired
	private AdmFuncionarioPerfilService admFuncionarioPerfilService;

	//@GetMapping("/findByMatriculaAndCPF/{id}/{cpf}")
	/**
	 * Find by matricula and CPF.
	 *
	 * @param principal the principal
	 * @param id the id
	 * @param cpf the cpf
	 * @return the response entity
	 */
	//http://localhost:8080/admFuncionarios/findByMatriculaAndCPF?id=93203&cpf=02685748474
	@ApiOperation("Find Funcionario By Matricula And CPF")
	@GetMapping(value="/findByMatriculaAndCPF", params = {"id","cpf"})
	public ResponseEntity<AdmFuncionario> findByMatriculaAndCPF(Principal principal, @RequestParam("id") Long id, @RequestParam("cpf") BigDecimal cpf) {
		validateUser(principal);
		
		Optional<AdmFuncionario> obj = servico.findByMatriculaAndCPF(id, cpf);

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(obj.get());
	}

	/**
	 * Delete by perfil.
	 *
	 * @param principal the principal
	 * @param perfilSeq the perfil seq
	 * @return the response entity
	 */
	@ApiOperation("Delete Funcionario By perfilSeq")
	@DeleteMapping("/deleteByPerfil/{perfilSeq}")
	public ResponseEntity<Void> deleteByPerfil(Principal principal, @PathVariable Long perfilSeq) {
		validateUser(principal);
		try {

			admFuncionarioPerfilService.deleteByPerfil(perfilSeq);
			return ResponseEntity.noContent().build();

		} catch (TransacaoException e) {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * Delete by funcionarios.
	 *
	 * @param principal the principal
	 * @param funcionarios the funcionarios
	 * @return the response entity
	 */
	@ApiOperation("Delete Funcionarios")
	@DeleteMapping("/deleteByFuncionarios/{funcionarios}")
	public ResponseEntity<Void> deleteByFuncionarios(Principal principal, @PathVariable List<AdmFuncionario> funcionarios) {
		validateUser(principal);
		try {

			admFuncionarioPerfilService.deleteByFuncionarios(funcionarios);
			return ResponseEntity.noContent().build();

		} catch (TransacaoException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
