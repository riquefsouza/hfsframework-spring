/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class BaseRestController.
 *
 * @param <T> the generic type
 * @param <I> the generic type
 * @param <S> the generic type
 */
@Api
public abstract class BaseRestController<T, I extends Serializable, 
	S extends BaseBusinessService<T, I, ? extends JpaRepository<T, I>>> {

	/** The log. */
	protected Logger log = LoggerFactory.getLogger(BaseRestController.class);

	/** The adm usuario repository. */
	@Autowired
	private AdmUsuarioRepository admUsuarioRepository;
	
	/** The servico. */
	@Autowired
	protected S servico;

	/**
	 * Search.
	 *
	 * @param principal the principal
	 * @param id the id
	 * @return the response entity
	 */
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

	/**
	 * Listar.
	 *
	 * @param principal the principal
	 * @return the iterable
	 */
	@ApiOperation("List all")
	@GetMapping
	public Iterable<T> listar(Principal principal) {
		this.validateUser(principal);
		
		return servico.findAll();
	}

	/**
	 * Pages.
	 *
	 * @param principal the principal
	 * @param p the p
	 * @return the page
	 */
	@ApiOperation("Pages")
	@GetMapping("/pages")
	@ResponseBody
	public Page<T> pages(Principal principal, Pageable p) {
		this.validateUser(principal);
		
		return servico.findAll(p);
	}

	/**
	 * Insert.
	 *
	 * @param principal the principal
	 * @param bean the bean
	 * @return the optional
	 */
	@ApiOperation("Insert bean")
	@PostMapping
	public Optional<T> insert(Principal principal, @Valid @RequestBody T bean) {
		this.validateUser(principal);
		
		return servico.insert(bean);
	}

	/**
	 * Update.
	 *
	 * @param principal the principal
	 * @param id the id
	 * @param bean the bean
	 * @return the response entity
	 */
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

	/**
	 * Delete.
	 *
	 * @param principal the principal
	 * @param id the id
	 * @return the response entity
	 */
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

	/**
	 * Validate user.
	 *
	 * @param principal the principal
	 */
	protected void validateUser(Principal principal) {
		String userId = principal.getName();
		this.admUsuarioRepository
			.findByLogin(userId)
			.orElseThrow(
				() -> new UserNotFoundException(userId));
	}	
}
