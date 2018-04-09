package br.com.hfsframework.base;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.util.ReflectionUtils;

public abstract class BaseResourceSupport<T, I extends Serializable, 
	C extends BaseResourceRestController<T, I, ?, ?>>
		extends ResourceSupport {

	public static final String LIST_ALL = "listAll";

	private final T bean;

	public BaseResourceSupport(C controller, T bean) {
		this.bean = bean;

		Method metodo = ReflectionUtils.findMethod(bean.getClass(), "getId");
		Long id = (Long) ReflectionUtils.invokeMethod(metodo, bean);
		
		this.add(linkTo(methodOn(controller.getClass()).search(id)).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar()).withRel(LIST_ALL));
	}

	public T getBean() {
		return bean;
	}
	
	/*
	public Resources<BaseResourceSupport> getLista(Iterable<T> lista) {
		Stream<T> stream = StreamSupport.stream(lista.spliterator(), false);

		List<BaseResourceSupport> listaResource = stream.map(BaseResourceSupport::new)
				.collect(Collectors.toList());

		return new Resources<BaseResourceSupport>(listaResource);
	}
	 */
}
