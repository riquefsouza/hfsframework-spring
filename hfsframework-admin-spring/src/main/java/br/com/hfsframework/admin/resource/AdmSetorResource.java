/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class AdmSetorResource.
 */
public class AdmSetorResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmSetor, String, AdmSetorRestController> {

	public AdmSetorResource(AdmSetorRestController controller, AdmSetor bean) {
		super(controller, bean);
	}
	*/

	/** The adm setor. */
	private final AdmSetor admSetor;

	/**
	 * Instantiates a new adm setor resource.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param admSetor the adm setor
	 */
	public AdmSetorResource(AdmSetorRestController controller, Principal principal, AdmSetor admSetor) {
		this.admSetor = admSetor;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admSetor.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	/**
	 * Gets the adm setor.
	 *
	 * @return the adm setor
	 */
	public AdmSetor getAdmSetor() {
		return admSetor;
	}

	/**
	 * Gets the lista.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param lista the lista
	 * @return the lista
	 */
	public static Resources<AdmSetorResource> getLista(AdmSetorRestController controller, Principal principal, Iterable<AdmSetor> lista){
		Stream<AdmSetor> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmSetorResource> listaResource = stream.map(bean -> new AdmSetorResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmSetorResource>(listaResource);
	}
	
}
