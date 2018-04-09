package br.com.hfsframework.base;

import java.io.Serializable;
import java.security.Principal;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.hfsframework.admin.data.AdmUsuarioRepository;
import br.com.hfsframework.util.exceptions.UserNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
public abstract class BaseRestController<T, I extends Serializable, 
	S extends BaseBusinessService<T, I, ? extends JpaRepository<T, I>>> {

	protected Logger log = LoggerFactory.getLogger(BaseRestController.class);

	@Autowired
	private AdmUsuarioRepository admUsuarioRepository;
	
	@Autowired
	protected S servico;

	@ApiOperation("Search by id")
	@GetMapping("/{id}")
	public ResponseEntity<T> search(Principal principal, @PathVariable I id) {
		this.validateUser(principal);
		
		Optional<T> obj = servico.load(id);

		if (!obj.isPresent()) {
			log.info("SEARCH NOT FOUND: " + id);
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(obj.get());
	}

	@ApiOperation("List all")
	@GetMapping
	public Iterable<T> listar(Principal principal) {
		this.validateUser(principal);
		
		return servico.findAll();
	}

	@ApiOperation("Pages")
	@GetMapping("/pages")
	@ResponseBody
	public Page<T> pages(Principal principal, Pageable p) {
		this.validateUser(principal);
		
		return servico.findAll(p);
	}

	@ApiOperation("Insert bean")
	@PostMapping
	public Optional<T> insert(Principal principal, @Valid @RequestBody T bean) {
		this.validateUser(principal);
		
		return servico.insert(bean);
	}

	@ApiOperation("Update bean")
	@PutMapping("/{id}")
	public ResponseEntity<T> update(Principal principal, @PathVariable I id, @Valid @RequestBody T bean) {
		this.validateUser(principal);
		
		Optional<T> obj = servico.load(id);

		if (!obj.isPresent()) {
			log.info("UPDATE NOT FOUND: " + bean.toString());
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(bean, obj, "id");

		obj = servico.update(obj.get());

		return ResponseEntity.ok(obj.get());
	}

	@ApiOperation("Delete bean")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(Principal principal, @PathVariable I id) {
		this.validateUser(principal);
		
		Optional<T> obj = servico.load(id);

		if (!obj.isPresent()) {
			log.info("DELETE NOT FOUND: " + id);
			return ResponseEntity.notFound().build();
		}

		servico.delete(obj.get());

		return ResponseEntity.noContent().build();
	}

	protected void validateUser(Principal principal) {
		String userId = principal.getName();
		this.admUsuarioRepository
			.findByLogin(userId)
			.orElseThrow(
				() -> new UserNotFoundException(userId));
	}	
}
