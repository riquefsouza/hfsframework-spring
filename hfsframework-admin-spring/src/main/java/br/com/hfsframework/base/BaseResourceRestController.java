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

@Api
public abstract class BaseResourceRestController<T, I extends Serializable, 
	S extends BaseBusinessService<T, I, ? extends JpaRepository<T, I>>,
	R extends ResourceSupport> {

	protected Logger log = LoggerFactory.getLogger(BaseResourceRestController.class);
	
	@Autowired
	protected S servico;

	@ApiOperation("Search with Resource by id")
	@GetMapping(value = "/{id}", produces = "application/json")
	public abstract R search(@PathVariable(value="id") I id);

	@ApiOperation("List all with Resource")
	@GetMapping(produces = "application/json")
	public abstract Resources<R> listar();

	@ApiOperation("Pages")
	@GetMapping("/pages")
	@ResponseBody
	public Page<T> pages(Pageable p) {
		return servico.findAll(p);
	}
	
	@ApiOperation("Insert bean")
	@PostMapping
	public Optional<T> insert(@Valid @RequestBody T bean) {
		return servico.insert(bean);
	}

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
