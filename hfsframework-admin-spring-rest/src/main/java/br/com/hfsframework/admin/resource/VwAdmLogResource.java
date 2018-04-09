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

import br.com.hfsframework.admin.model.VwAdmLog;
import br.com.hfsframework.admin.restcontroller.VwAdmLogRestController;
import br.com.hfsframework.base.BaseResourceSupport;

public class VwAdmLogResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<VwAdmLog, Long, VwAdmLogRestController> {

	public VwAdmLogResource(VwAdmLogRestController controller, VwAdmLog bean) {
		super(controller, bean);
	}
	*/

	private final VwAdmLog vwAdmLog;

	public VwAdmLogResource(VwAdmLogRestController controller, Principal principal, VwAdmLog vwAdmLog) {
		this.vwAdmLog = vwAdmLog;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, vwAdmLog.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	public VwAdmLog getVwAdmLog() {
		return vwAdmLog;
	}

	public static Resources<VwAdmLogResource> getLista(VwAdmLogRestController controller, Principal principal, Iterable<VwAdmLog> lista){
		Stream<VwAdmLog> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<VwAdmLogResource> listaResource = stream.map(bean -> new VwAdmLogResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<VwAdmLogResource>(listaResource);
	}
	
}
