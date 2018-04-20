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

import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.admin.restcontroller.AdmParametroCategoriaRestController;
import br.com.hfsframework.base.BaseResourceSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmParametroCategoriaResource.
 */
public class AdmParametroCategoriaResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmParametroCategoria, Long, AdmParametroCategoriaRestController> {

	public AdmParametroCategoriaResource(AdmParametroCategoriaRestController controller, AdmParametroCategoria bean) {
		super(controller, bean);
	}
	*/

	/** The adm parametro categoria. */
	private final AdmParametroCategoria admParametroCategoria;

	/**
	 * Instantiates a new adm parametro categoria resource.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param admParametroCategoria the adm parametro categoria
	 */
	public AdmParametroCategoriaResource(AdmParametroCategoriaRestController controller, Principal principal, AdmParametroCategoria admParametroCategoria) {
		this.admParametroCategoria = admParametroCategoria;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admParametroCategoria.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	/**
	 * Gets the adm parametro categoria.
	 *
	 * @return the adm parametro categoria
	 */
	public AdmParametroCategoria getAdmParametroCategoria() {
		return admParametroCategoria;
	}

	/**
	 * Gets the lista.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param lista the lista
	 * @return the lista
	 */
	public static Resources<AdmParametroCategoriaResource> getLista(AdmParametroCategoriaRestController controller, Principal principal, Iterable<AdmParametroCategoria> lista){
		Stream<AdmParametroCategoria> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmParametroCategoriaResource> listaResource = stream.map(bean -> new AdmParametroCategoriaResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmParametroCategoriaResource>(listaResource);
	}
	
}
