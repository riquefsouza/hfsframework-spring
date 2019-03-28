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

import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.admin.restcontroller.AdmMenuRestController;
import br.com.hfsframework.base.BaseResourceSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmMenuResource.
 */
public class AdmMenuResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmMenu, Long, AdmMenuRestController> {

	public AdmMenuResource(AdmMenuRestController controller, AdmMenu bean) {
		super(controller, bean);
	}
	*/

	/** The adm menu. */
	private final AdmMenu admMenu;

	/**
	 * Instantiates a new adm menu resource.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param admMenu the adm menu
	 */
	public AdmMenuResource(AdmMenuRestController controller, Principal principal, AdmMenu admMenu) {
		this.admMenu = admMenu;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admMenu.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	/**
	 * Gets the adm menu.
	 *
	 * @return the adm menu
	 */
	public AdmMenu getAdmMenu() {
		return admMenu;
	}

	/**
	 * Gets the lista.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param lista the lista
	 * @return the lista
	 */
	public static Resources<AdmMenuResource> getLista(AdmMenuRestController controller, Principal principal, Iterable<AdmMenu> lista){
		Stream<AdmMenu> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmMenuResource> listaResource = stream.map(bean -> new AdmMenuResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmMenuResource>(listaResource);
	}
	
}
