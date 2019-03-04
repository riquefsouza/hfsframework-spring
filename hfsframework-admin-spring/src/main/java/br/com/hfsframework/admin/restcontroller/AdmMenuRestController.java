/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.restcontroller;

import java.security.Principal;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.admin.service.AdmMenuService;
import br.com.hfsframework.base.BaseRestController;
import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmMenuRestController.
 */
@RestController
@RequestMapping("/admMenus")
public class AdmMenuRestController extends BaseRestController<AdmMenu, Long, AdmMenuService> {

	/**
	 * Salvar ou atualizar drag reordenando.
	 *
	 * @param principal the principal
	 * @param idMenuPaiAntigo the id menu pai antigo
	 * @param idMenuPaiNovo the id menu pai novo
	 * @param idMenuMover the id menu mover
	 * @return the response entity
	 */
	@ApiOperation("Save Or Update Menu Drag And Drop")
	@PutMapping(value = "/salvarOuAtualizarDragReordenando", 
			params = { "idMenuPaiAntigo", "idMenuPaiNovo", "idMenuMover" })
	public ResponseEntity<AdmMenu> salvarOuAtualizarDragReordenando(Principal principal, 
			@RequestParam("idMenuPaiAntigo") Long idMenuPaiAntigo, 
			@RequestParam("idMenuPaiNovo") Long idMenuPaiNovo,
			@RequestParam("idMenuMover") Long idMenuMover) {
		validateUser(principal);
		
		Optional<AdmMenu> menuPaiAntigo = servico.load(idMenuPaiAntigo);
		Optional<AdmMenu> menuPaiNovo = servico.load(idMenuPaiNovo);
		Optional<AdmMenu> menuMover = servico.load(idMenuMover);

		Optional<AdmMenu> obj = servico.salvarOuAtualizarDragReordenando(
				menuPaiAntigo.get(), menuPaiNovo.get(),	menuMover.get());

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(obj.get());
	}
	
	/**
	 * Salvar ou atualizar.
	 *
	 * @param principal the principal
	 * @param bean the bean
	 * @return the response entity
	 */
	@ApiOperation("Save Or Update Menu")
	@PostMapping("/salvarOuAtualizar")
	public ResponseEntity<AdmMenu> salvarOuAtualizar(Principal principal, @Valid @RequestBody AdmMenu bean) {
		validateUser(principal);
		
		Optional<AdmMenu> obj = servico.salvarOuAtualizar(bean);

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(bean, obj, "id");

		obj = servico.update(obj.get());

		return ResponseEntity.ok(obj.get());
		
	}
	
	/**
	 * Apagar.
	 *
	 * @param principal the principal
	 * @param idMenu the id menu
	 * @return the response entity
	 */
	@ApiOperation("Delete Menu By idMenu")
	@DeleteMapping("/apagarMenu/{id}")
	public ResponseEntity<Void> apagar(Principal principal, @PathVariable Long idMenu) {
		validateUser(principal);
		
		Optional<AdmMenu> obj = servico.load(idMenu);

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		servico.apagar(obj.get());

		return ResponseEntity.noContent().build();
	}
}
