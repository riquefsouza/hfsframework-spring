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

import br.com.hfsframework.admin.model.AdmSetor;
import br.com.hfsframework.admin.restcontroller.AdmSetorRestController;
import br.com.hfsframework.base.BaseResourceSupport;

public class AdmSetorResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmSetor, String, AdmSetorRestController> {

	public AdmSetorResource(AdmSetorRestController controller, AdmSetor bean) {
		super(controller, bean);
	}
	*/

	private final AdmSetor admSetor;

	public AdmSetorResource(AdmSetorRestController controller, Principal principal, AdmSetor admSetor) {
		this.admSetor = admSetor;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admSetor.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	public AdmSetor getAdmSetor() {
		return admSetor;
	}

	public static Resources<AdmSetorResource> getLista(AdmSetorRestController controller, Principal principal, Iterable<AdmSetor> lista){
		Stream<AdmSetor> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmSetorResource> listaResource = stream.map(bean -> new AdmSetorResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmSetorResource>(listaResource);
	}
	
}
