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

import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.admin.restcontroller.AdmPaginaRestController;
import br.com.hfsframework.base.BaseResourceSupport;

public class AdmPaginaResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmPagina, Long, AdmPaginaRestController> {

	public AdmPaginaResource(AdmPaginaRestController controller, AdmPagina bean) {
		super(controller, bean);
	}
	*/

	private final AdmPagina admPagina;

	public AdmPaginaResource(AdmPaginaRestController controller, Principal principal, AdmPagina admPagina) {
		this.admPagina = admPagina;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admPagina.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	public AdmPagina getAdmPagina() {
		return admPagina;
	}

	public static Resources<AdmPaginaResource> getLista(AdmPaginaRestController controller, Principal principal, Iterable<AdmPagina> lista){
		Stream<AdmPagina> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmPaginaResource> listaResource = stream.map(bean -> new AdmPaginaResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmPaginaResource>(listaResource);
	}
	
}
