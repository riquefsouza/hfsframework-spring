/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admCargo;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/findCargoByCodFuncionario/{codFuncionario}")
	public Iterable<AdmCargo> findCargoByCodFuncionario(@PathVariable Long codFuncionario) {
		return admCargoFuncionarioService.findCargoByCodFuncionario(codFuncionario);
	}
	
	/**
	 * Find funcionario by cod cargo.
	 *
	 * @param codCargo the cod cargo
	 * @return the iterable
	 */
	@GetMapping("/findFuncionarioByCodCargo/{codCargo}")
	public Iterable<AdmFuncionario> findFuncionarioByCodCargo(@PathVariable Long codCargo) {
		return admCargoFuncionarioService.findFuncionarioByCodCargo(codCargo);
	}
	
	/**
	 * Find perfil by cod cargo.
	 *
	 * @param codCargo the cod cargo
	 * @return the iterable
	 */
	@GetMapping("/findPerfilByCodCargo/{codCargo}")
	public Iterable<AdmPerfil> findPerfilByCodCargo(@PathVariable Long codCargo) {
		return admCargoPerfilService.findPerfilByCodCargo(codCargo);
	}
	
}
