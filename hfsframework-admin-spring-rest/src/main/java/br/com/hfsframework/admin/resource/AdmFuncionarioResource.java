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

import br.com.hfsframework.admin.model.AdmFuncionario;
import br.com.hfsframework.admin.restcontroller.AdmFuncionarioRestController;
import br.com.hfsframework.base.BaseResourceSupport;

public class AdmFuncionarioResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmFuncionario, Long, AdmFuncionarioRestController> {

	public AdmFuncionarioResource(AdmFuncionarioRestController controller, AdmFuncionario bean) {
		super(controller, bean);
	}
	*/

	private final AdmFuncionario admFuncionario;

	public AdmFuncionarioResource(AdmFuncionarioRestController controller, Principal principal, AdmFuncionario admFuncionario) {
		this.admFuncionario = admFuncionario;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admFuncionario.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	public AdmFuncionario getAdmFuncionario() {
		return admFuncionario;
	}

	public static Resources<AdmFuncionarioResource> getLista(AdmFuncionarioRestController controller, Principal principal, Iterable<AdmFuncionario> lista){
		Stream<AdmFuncionario> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmFuncionarioResource> listaResource = stream.map(bean -> new AdmFuncionarioResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmFuncionarioResource>(listaResource);
	}
	
}
