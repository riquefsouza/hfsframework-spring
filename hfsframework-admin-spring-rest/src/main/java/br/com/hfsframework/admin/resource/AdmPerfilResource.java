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

import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.restcontroller.AdmPerfilRestController;
import br.com.hfsframework.base.BaseResourceSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmPerfilResource.
 */
public class AdmPerfilResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmPerfil, Long, AdmPerfilRestController> {

	public AdmPerfilResource(AdmPerfilRestController controller, AdmPerfil bean) {
		super(controller, bean);
	}
	*/

	/** The adm perfil. */
	private final AdmPerfil admPerfil;

	/**
	 * Instantiates a new adm perfil resource.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param admPerfil the adm perfil
	 */
	public AdmPerfilResource(AdmPerfilRestController controller, Principal principal, AdmPerfil admPerfil) {
		this.admPerfil = admPerfil;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admPerfil.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	/**
	 * Gets the adm perfil.
	 *
	 * @return the adm perfil
	 */
	public AdmPerfil getAdmPerfil() {
		return admPerfil;
	}

	/**
	 * Gets the lista.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param lista the lista
	 * @return the lista
	 */
	public static Resources<AdmPerfilResource> getLista(AdmPerfilRestController controller, Principal principal, Iterable<AdmPerfil> lista){
		Stream<AdmPerfil> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmPerfilResource> listaResource = stream.map(bean -> new AdmPerfilResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmPerfilResource>(listaResource);
	}
	
}
