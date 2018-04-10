package br.com.hfsframework.admin.restcontroller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmCargo;
import br.com.hfsframework.admin.model.AdmFuncionario;
import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.service.AdmCargoFuncionarioService;
import br.com.hfsframework.admin.service.AdmCargoPerfilService;
import br.com.hfsframework.admin.service.AdmCargoService;
import br.com.hfsframework.base.BaseRestController;
import br.com.hfsframework.util.exceptions.TransacaoException;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admCargos")
public class AdmCargoRestController extends BaseRestController<AdmCargo, Long, AdmCargoService> {

	@Autowired
	private AdmCargoFuncionarioService admCargoFuncionarioService;

	@Autowired
	private AdmCargoPerfilService admCargoPerfilService;

	@ApiOperation("Find Cargo By codFuncionario")
	@GetMapping("/findCargoByCodFuncionario/{codFuncionario}")
	public Iterable<AdmCargo> findCargoByCodFuncionario(Principal principal, @PathVariable Long codFuncionario) {
		validateUser(principal);
		return admCargoFuncionarioService.findCargoByCodFuncionario(codFuncionario);
	}

	@ApiOperation("Find Funcionario By codCargo")
	@GetMapping("/findFuncionarioByCodCargo/{codCargo}")
	public Iterable<AdmFuncionario> findFuncionarioByCodCargo(Principal principal, @PathVariable Long codCargo) {
		validateUser(principal);
		return admCargoFuncionarioService.findFuncionarioByCodCargo(codCargo);
	}
	
	@ApiOperation("Find Perfil By codCargo")
	@GetMapping("/findPerfilByCodCargo/{codCargo}")
	public Iterable<AdmPerfil> findPerfilByCodCargo(Principal principal, @PathVariable Long codCargo) {
		validateUser(principal);
		return admCargoPerfilService.findPerfilByCodCargo(codCargo);
	}

	@ApiOperation("Delete Cargo By perfilSeq")
	@DeleteMapping("/deleteByPerfil/{perfilSeq}")
	public ResponseEntity<Void> deleteByPerfil(Principal principal, @PathVariable Long perfilSeq) {
		validateUser(principal);
		try {
			
			admCargoPerfilService.deleteByPerfil(perfilSeq);
			return ResponseEntity.noContent().build();
			
		} catch (TransacaoException e) {
			return ResponseEntity.notFound().build();
		}
	}

	//Map<String, String> varsMap
	//MultiValueMap<String, String>
	
	@ApiOperation("Delete Cargos")
	@DeleteMapping("/deleteByCargos/{cargos}")
	public ResponseEntity<Void> deleteByCargos(Principal principal, @PathVariable List<AdmCargo> cargos) {
		validateUser(principal);
		try {

			admCargoPerfilService.deleteByCargos(cargos);
			return ResponseEntity.noContent().build();
			
		} catch (TransacaoException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
