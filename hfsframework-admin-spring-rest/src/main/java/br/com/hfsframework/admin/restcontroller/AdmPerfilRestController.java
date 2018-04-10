package br.com.hfsframework.admin.restcontroller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmCargo;
import br.com.hfsframework.admin.model.AdmFuncionario;
import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.service.AdmPerfilService;
import br.com.hfsframework.base.BaseRestController;
import br.com.hfsframework.security.model.PermissaoVO;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admPerfis")
public class AdmPerfilRestController extends BaseRestController<AdmPerfil, Long, AdmPerfilService> {

	@ApiOperation("Get Perfils By idAdmFuncionario")
	@GetMapping("/getPapeis/{idAdmFuncionario}")
	public ResponseEntity<HashSet<AdmPerfil>> getPapeis(Principal principal, @PathVariable Long idAdmFuncionario) {
		validateUser(principal);
		
		HashSet<AdmPerfil> obj = servico.getPapeis(idAdmFuncionario);

		if (!obj.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(obj);
	}

	@ApiOperation("Get Permissoes By idAdmFuncionario")
	@GetMapping("/getPermissao/{idAdmFuncionario}")
	public Iterable<PermissaoVO> getPermissao(Principal principal, @PathVariable Long idAdmFuncionario) {
		validateUser(principal);
		return servico.getPermissao(idAdmFuncionario);
	}

	@ApiOperation("Get Admin Menus Pai By idAdmPerfil")
	@GetMapping("/findAdminMenuPaiByPerfil/{idAdmPerfil}")
	public Iterable<AdmMenu> findAdminMenuPaiByPerfil(Principal principal, @PathVariable Long idAdmPerfil) {
		validateUser(principal);
		Optional<AdmPerfil> perfil = servico.load(idAdmPerfil);
		return servico.findAdminMenuPaiByPerfil(perfil.get());
	}

	@ApiOperation("Get Menus Pai By idAdmPerfil")
	@GetMapping("/findMenuPaiByPerfil/{idAdmPerfil}")
	public Iterable<AdmMenu> findMenuPaiByPerfil(Principal principal, @PathVariable Long idAdmPerfil) {
		validateUser(principal);
		Optional<AdmPerfil> perfil = servico.load(idAdmPerfil);
		return servico.findMenuPaiByPerfil(perfil.get());
	}

	@ApiOperation("Get Funcionarios By idAdmPerfil")
	@GetMapping("/findFuncionariosPorPerfil/{idAdmPerfil}")
	public Iterable<AdmFuncionario> findFuncionariosPorPerfil(Principal principal, @PathVariable Long idAdmPerfil) {
		validateUser(principal);
		Optional<AdmPerfil> perfil = servico.load(idAdmPerfil);
		return servico.findFuncionariosPorPerfil(perfil.get());
	}

	@ApiOperation("Get Cargos By idAdmPerfil")
	@GetMapping("/findCargosPorPerfil/{idAdmPerfil}")
	public Iterable<AdmCargo> findCargosPorPerfil(Principal principal, @PathVariable Long idAdmPerfil) {
		validateUser(principal);
		Optional<AdmPerfil> perfil = servico.load(idAdmPerfil);
		return servico.findCargosPorPerfil(perfil.get());
	}
}
