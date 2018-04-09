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

import br.com.hfsframework.admin.model.AdmFuncionalidade;
import br.com.hfsframework.admin.restcontroller.AdmFuncionalidadeRestController;
import br.com.hfsframework.base.BaseResourceSupport;

public class AdmFuncionalidadeResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmFuncionalidade, Long, AdmFuncionalidadeRestController> {

	public AdmFuncionalidadeResource(AdmFuncionalidadeRestController controller, AdmFuncionalidade bean) {
		super(controller, bean);
	}
	*/

	private final AdmFuncionalidade admFuncionalidade;

	public AdmFuncionalidadeResource(AdmFuncionalidadeRestController controller, Principal principal, AdmFuncionalidade admFuncionalidade) {
		this.admFuncionalidade = admFuncionalidade;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admFuncionalidade.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	public AdmFuncionalidade getAdmFuncionalidade() {
		return admFuncionalidade;
	}

	public static Resources<AdmFuncionalidadeResource> getLista(AdmFuncionalidadeRestController controller, Principal principal, Iterable<AdmFuncionalidade> lista){
		Stream<AdmFuncionalidade> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmFuncionalidadeResource> listaResource = stream.map(bean -> new AdmFuncionalidadeResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmFuncionalidadeResource>(listaResource);
	}
	
}
