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

import br.com.hfsframework.admin.model.AdmParametro;
import br.com.hfsframework.admin.restcontroller.AdmParametroRestController;
import br.com.hfsframework.base.BaseResourceSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmParametroResource.
 */
public class AdmParametroResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmParametro, Long, AdmParametroRestController> {

	public AdmParametroResource(AdmParametroRestController controller, AdmParametro bean) {
		super(controller, bean);
	}
	*/

	/** The adm parametro. */
	private final AdmParametro admParametro;

	/**
	 * Instantiates a new adm parametro resource.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param admParametro the adm parametro
	 */
	public AdmParametroResource(AdmParametroRestController controller, Principal principal, AdmParametro admParametro) {
		this.admParametro = admParametro;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admParametro.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	/**
	 * Gets the adm parametro.
	 *
	 * @return the adm parametro
	 */
	public AdmParametro getAdmParametro() {
		return admParametro;
	}

	/**
	 * Gets the lista.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param lista the lista
	 * @return the lista
	 */
	public static Resources<AdmParametroResource> getLista(AdmParametroRestController controller, Principal principal, Iterable<AdmParametro> lista){
		Stream<AdmParametro> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmParametroResource> listaResource = stream.map(bean -> new AdmParametroResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmParametroResource>(listaResource);
	}
	
}
