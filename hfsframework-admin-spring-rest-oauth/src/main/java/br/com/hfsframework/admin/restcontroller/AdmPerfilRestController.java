/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.restcontroller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.service.AdmPerfilService;
import br.com.hfsframework.base.BaseRestController;
import br.com.hfsframework.security.model.PermissaoVO;
import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmPerfilRestController.
 */
@RestController
@RequestMapping("/admPerfis")
public class AdmPerfilRestController extends BaseRestController<AdmPerfil, Long, AdmPerfilService> {

	/**
	 * Gets the papeis.
	 *
	 * @param principal the principal
	 * @param idAdmUsuario the id adm funcionario
	 * @return the papeis
	 */
	@ApiOperation("Get Perfils By idAdmUsuario")
	@GetMapping("/getPapeis/{idAdmUsuario}")
	public ResponseEntity<HashSet<AdmPerfil>> getPapeis(Principal principal, @PathVariable Long idAdmUsuario) {
		validateUser(principal);
		
		HashSet<AdmPerfil> obj = servico.getPapeis(idAdmUsuario);

		if (!obj.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(obj);
	}

	/**
	 * Gets the permissao.
	 *
	 * @param principal the principal
	 * @param idAdmUsuario the id adm funcionario
	 * @return the permissao
	 */
	@ApiOperation("Get Permissoes By idAdmUsuario")
	@GetMapping("/getPermissao/{idAdmUsuario}")
	public Iterable<PermissaoVO> getPermissao(Principal principal, @PathVariable Long idAdmUsuario) {
		validateUser(principal);
		return servico.getPermissao(idAdmUsuario);
	}

	/**
	 * Find admin menu pai by perfil.
	 *
	 * @param principal the principal
	 * @param idAdmPerfil the id adm perfil
	 * @return the iterable
	 */
	@ApiOperation("Get Admin Menus Pai By idAdmPerfil")
	@GetMapping("/findAdminMenuPaiByPerfil/{idAdmPerfil}")
	public Iterable<AdmMenu> findAdminMenuPaiByPerfil(Principal principal, @PathVariable Long idAdmPerfil) {
		validateUser(principal);
		Optional<AdmPerfil> perfil = servico.load(idAdmPerfil);
		return servico.findAdminMenuPaiByPerfil(perfil.get());
	}

	/**
	 * Find menu pai by perfil.
	 *
	 * @param principal the principal
	 * @param idAdmPerfil the id adm perfil
	 * @return the iterable
	 */
	@ApiOperation("Get Menus Pai By idAdmPerfil")
	@GetMapping("/findMenuPaiByPerfil/{idAdmPerfil}")
	public Iterable<AdmMenu> findMenuPaiByPerfil(Principal principal, @PathVariable Long idAdmPerfil) {
		validateUser(principal);
		Optional<AdmPerfil> perfil = servico.load(idAdmPerfil);
		return servico.findMenuPaiByPerfil(perfil.get());
	}

	/**
	 * Find funcionarios por perfil.
	 *
	 * @param principal the principal
	 * @param idAdmPerfil the id adm perfil
	 * @return the iterable
	 */
	@ApiOperation("Get Usuarios By idAdmPerfil")
	@GetMapping("/findUsuariosPorPerfil/{idAdmPerfil}")
	public Iterable<AdmUsuario> findUsuariosPorPerfil(Principal principal, @PathVariable Long idAdmPerfil) {
		validateUser(principal);
		Optional<AdmPerfil> perfil = servico.load(idAdmPerfil);
		return servico.findUsuariosPorPerfil(perfil.get());
	}

}
