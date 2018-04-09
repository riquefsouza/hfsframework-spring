package br.com.hfsframework.admin.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;

import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.admin.restcontroller.AdmParametroCategoriaRestController;
import br.com.hfsframework.base.BaseResourceSupport;

public class AdmParametroCategoriaResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmParametroCategoria, Long, AdmParametroCategoriaRestController> {

	public AdmParametroCategoriaResource(AdmParametroCategoriaRestController controller, AdmParametroCategoria bean) {
		super(controller, bean);
	}
	*/

	private final AdmParametroCategoria admParametroCategoria;

	public AdmParametroCategoriaResource(AdmParametroCategoriaRestController controller, Principal principal, AdmParametroCategoria admParametroCategoria) {
		this.admParametroCategoria = admParametroCategoria;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admParametroCategoria.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	public AdmParametroCategoria getAdmParametroCategoria() {
		return admParametroCategoria;
	}

	public static Resources<AdmParametroCategoriaResource> getLista(AdmParametroCategoriaRestController controller, Principal principal, Iterable<AdmParametroCategoria> lista){
		Stream<AdmParametroCategoria> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmParametroCategoriaResource> listaResource = stream.map(bean -> new AdmParametroCategoriaResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmParametroCategoriaResource>(listaResource);
	}
	
}
