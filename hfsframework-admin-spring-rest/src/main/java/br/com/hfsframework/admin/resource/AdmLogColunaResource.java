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

import br.com.hfsframework.admin.model.AdmLogColuna;
import br.com.hfsframework.admin.restcontroller.AdmLogColunaRestController;
import br.com.hfsframework.base.BaseResourceSupport;

public class AdmLogColunaResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmLogColuna, String, AdmLogColunaRestController> {

	public AdmLogColunaResource(AdmLogColunaRestController controller, AdmLogColuna bean) {
		super(controller, bean);
	}
	*/

	private final AdmLogColuna admLogColuna;

	public AdmLogColunaResource(AdmLogColunaRestController controller, Principal principal, AdmLogColuna admLogColuna) {
		this.admLogColuna = admLogColuna;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admLogColuna.getNome())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	public AdmLogColuna getAdmLogColuna() {
		return admLogColuna;
	}

	public static Resources<AdmLogColunaResource> getLista(AdmLogColunaRestController controller, Principal principal, Iterable<AdmLogColuna> lista){
		Stream<AdmLogColuna> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmLogColunaResource> listaResource = stream.map(bean -> new AdmLogColunaResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmLogColunaResource>(listaResource);
	}
	
}
