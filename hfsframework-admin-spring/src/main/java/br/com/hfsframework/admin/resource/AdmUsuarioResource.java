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

import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.restcontroller.AdmUsuarioRestController;
import br.com.hfsframework.base.BaseResourceSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmUsuarioResource.
 */
public class AdmUsuarioResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmUsuario, Long, AdmUsuarioRestController> {

	public AdmUsuarioResource(AdmUsuarioRestController controller, AdmUsuario bean) {
		super(controller, bean);
	}
	*/

	/** The adm usuario. */
	private final AdmUsuario admUsuario;

	/**
	 * Instantiates a new adm usuario resource.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param admUsuario the adm usuario
	 */
	public AdmUsuarioResource(AdmUsuarioRestController controller, Principal principal, AdmUsuario admUsuario) {
		this.admUsuario = admUsuario;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admUsuario.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	/**
	 * Gets the adm usuario.
	 *
	 * @return the adm usuario
	 */
	public AdmUsuario getAdmUsuario() {
		return admUsuario;
	}

	/**
	 * Gets the lista.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param lista the lista
	 * @return the lista
	 */
	public static Resources<AdmUsuarioResource> getLista(AdmUsuarioRestController controller, Principal principal, Iterable<AdmUsuario> lista){
		Stream<AdmUsuario> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmUsuarioResource> listaResource = stream.map(bean -> new AdmUsuarioResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmUsuarioResource>(listaResource);
	}
	
}
