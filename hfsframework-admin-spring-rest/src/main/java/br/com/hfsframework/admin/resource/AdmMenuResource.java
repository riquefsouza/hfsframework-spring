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

import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.admin.restcontroller.AdmMenuRestController;
import br.com.hfsframework.base.BaseResourceSupport;

public class AdmMenuResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmMenu, Long, AdmMenuRestController> {

	public AdmMenuResource(AdmMenuRestController controller, AdmMenu bean) {
		super(controller, bean);
	}
	*/

	private final AdmMenu admMenu;

	public AdmMenuResource(AdmMenuRestController controller, Principal principal, AdmMenu admMenu) {
		this.admMenu = admMenu;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admMenu.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	public AdmMenu getAdmMenu() {
		return admMenu;
	}

	public static Resources<AdmMenuResource> getLista(AdmMenuRestController controller, Principal principal, Iterable<AdmMenu> lista){
		Stream<AdmMenu> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmMenuResource> listaResource = stream.map(bean -> new AdmMenuResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmMenuResource>(listaResource);
	}
	
}
