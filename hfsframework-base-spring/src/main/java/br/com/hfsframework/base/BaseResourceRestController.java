/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.base;

import java.io.Serializable;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseResourceRestController.
 *
 * @param <T> the generic type
 * @param <I> the generic type
 * @param <S> the generic type
 * @param <R> the generic type
 */
@Api
public abstract class BaseResourceRestController<T, I extends Serializable, 
	S extends BaseBusinessService<T, I, ? extends JpaRepository<T, I>>,
	R extends ResourceSupport> {

	/** The log. */
	protected Logger log = LoggerFactory.getLogger(BaseResourceRestController.class);
	
	/** The servico. */
	@Autowired
	protected S servico;

	/**
	 * Search.
	 *
	 * @param id the id
	 * @return the r
	 */
	@ApiOperation("Search with Resource by id")
	@GetMapping(value = "/{id}", produces = "application/json")
	public abstract R search(@PathVariable(value="id") I id);

	/**
	 * Listar.
	 *
	 * @return the resources
	 */
	@ApiOperation("List all with Resource")
	@GetMapping(produces = "application/json")
	public abstract Resources<R> listar();

	/**
	 * Pages.
	 *
	 * @param p the p
	 * @return the page
	 */
	@ApiOperation("Pages")
	@GetMapping("/pages")
	@ResponseBody
	public Page<T> pages(Pageable p) {
		return servico.findAll(p);
	}
	
	/**
	 * Insert.
	 *
	 * @param bean the bean
	 * @return the optional
	 */
	@ApiOperation("Insert bean")
	@PostMapping
	public Optional<T> insert(@Valid @RequestBody T bean) {
		return servico.insert(bean);
	}

	/**
	 * Update.
	 *
	 * @param id the id
	 * @param bean the bean
	 * @return the response entity
	 */
	@ApiOperation("Update bean")
	@PutMapping("/{id}")
	public ResponseEntity<T> update(@PathVariable I id, @Valid @RequestBody T bean) {
		Optional<T> obj = servico.load(id);

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(bean, obj, "id");

		obj = servico.update(obj.get());

		return ResponseEntity.ok(obj.get());
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@ApiOperation("Delete bean")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable I id) {
		Optional<T> obj = servico.load(id);

		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		servico.delete(obj.get());

		return ResponseEntity.noContent().build();
	}

}
