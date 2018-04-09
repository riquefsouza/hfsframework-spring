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

import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.restcontroller.AdmPerfilRestController;
import br.com.hfsframework.base.BaseResourceSupport;

public class AdmPerfilResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmPerfil, Long, AdmPerfilRestController> {

	public AdmPerfilResource(AdmPerfilRestController controller, AdmPerfil bean) {
		super(controller, bean);
	}
	*/

	private final AdmPerfil admPerfil;

	public AdmPerfilResource(AdmPerfilRestController controller, Principal principal, AdmPerfil admPerfil) {
		this.admPerfil = admPerfil;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admPerfil.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	public AdmPerfil getAdmPerfil() {
		return admPerfil;
	}

	public static Resources<AdmPerfilResource> getLista(AdmPerfilRestController controller, Principal principal, Iterable<AdmPerfil> lista){
		Stream<AdmPerfil> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmPerfilResource> listaResource = stream.map(bean -> new AdmPerfilResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmPerfilResource>(listaResource);
	}
	
}
