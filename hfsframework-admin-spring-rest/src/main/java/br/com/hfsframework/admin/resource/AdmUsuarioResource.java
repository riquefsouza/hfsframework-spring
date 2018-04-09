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

import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.restcontroller.AdmUsuarioRestController;
import br.com.hfsframework.base.BaseResourceSupport;

public class AdmUsuarioResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmUsuario, Long, AdmUsuarioRestController> {

	public AdmUsuarioResource(AdmUsuarioRestController controller, AdmUsuario bean) {
		super(controller, bean);
	}
	*/

	private final AdmUsuario admUsuario;

	public AdmUsuarioResource(AdmUsuarioRestController controller, Principal principal, AdmUsuario admUsuario) {
		this.admUsuario = admUsuario;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admUsuario.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	public AdmUsuario getAdmUsuario() {
		return admUsuario;
	}

	public static Resources<AdmUsuarioResource> getLista(AdmUsuarioRestController controller, Principal principal, Iterable<AdmUsuario> lista){
		Stream<AdmUsuario> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmUsuarioResource> listaResource = stream.map(bean -> new AdmUsuarioResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmUsuarioResource>(listaResource);
	}
	
}
