/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class AdmCargoRestController.
 */
@RestController
@RequestMapping("/admCargos")
public class AdmCargoRestController extends BaseRestController<AdmCargo, Long, AdmCargoService> {

	/** The adm cargo funcionario service. */
	@Autowired
	private AdmCargoFuncionarioService admCargoFuncionarioService;

	/** The adm cargo perfil service. */
	@Autowired
	private AdmCargoPerfilService admCargoPerfilService;

	/**
	 * Find cargo by cod funcionario.
	 *
	 * @param principal the principal
	 * @param codFuncionario the cod funcionario
	 * @return the iterable
	 */
	@ApiOperation("Find Cargo By codFuncionario")
	@GetMapping("/findCargoByCodFuncionario/{codFuncionario}")
	public Iterable<AdmCargo> findCargoByCodFuncionario(Principal principal, @PathVariable Long codFuncionario) {
		validateUser(principal);
		return admCargoFuncionarioService.findCargoByCodFuncionario(codFuncionario);
	}

	/**
	 * Find funcionario by cod cargo.
	 *
	 * @param principal the principal
	 * @param codCargo the cod cargo
	 * @return the iterable
	 */
	@ApiOperation("Find Funcionario By codCargo")
	@GetMapping("/findFuncionarioByCodCargo/{codCargo}")
	public Iterable<AdmFuncionario> findFuncionarioByCodCargo(Principal principal, @PathVariable Long codCargo) {
		validateUser(principal);
		return admCargoFuncionarioService.findFuncionarioByCodCargo(codCargo);
	}
	
	/**
	 * Find perfil by cod cargo.
	 *
	 * @param principal the principal
	 * @param codCargo the cod cargo
	 * @return the iterable
	 */
	@ApiOperation("Find Perfil By codCargo")
	@GetMapping("/findPerfilByCodCargo/{codCargo}")
	public Iterable<AdmPerfil> findPerfilByCodCargo(Principal principal, @PathVariable Long codCargo) {
		validateUser(principal);
		return admCargoPerfilService.findPerfilByCodCargo(codCargo);
	}

	/**
	 * Delete by perfil.
	 *
	 * @param principal the principal
	 * @param perfilSeq the perfil seq
	 * @return the response entity
	 */
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
	
	/**
	 * Delete by cargos.
	 *
	 * @param principal the principal
	 * @param cargos the cargos
	 * @return the response entity
	 */
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
