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

import br.com.hfsframework.admin.model.AdmCargo;
import br.com.hfsframework.admin.restcontroller.AdmCargoRestController;
import br.com.hfsframework.base.BaseResourceSupport;

public class AdmCargoResource extends ResourceSupport {

	/*
	 * extends BaseResourceSupport<AdmCargo, Long, AdmCargoRestController> {
	 * 
	 * public AdmCargoResource(AdmCargoRestController controller, AdmCargo bean)
	 * { super(controller, bean); }
	 */

	private final AdmCargo admCargo;

	public AdmCargoResource(AdmCargoRestController controller, Principal principal, AdmCargo admCargo) {
		this.admCargo = admCargo;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admCargo.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	public AdmCargo getAdmCargo() {
		return admCargo;
	}

	public static Resources<AdmCargoResource> getLista(AdmCargoRestController controller, Principal principal,
			Iterable<AdmCargo> lista) {
		Stream<AdmCargo> stream = StreamSupport.stream(lista.spliterator(), false);

		List<AdmCargoResource> listaResource = stream.map(bean -> new AdmCargoResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmCargoResource>(listaResource);
	}

}
