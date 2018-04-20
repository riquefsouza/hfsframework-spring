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

import br.com.hfsframework.admin.model.AdmFuncionalidade;
import br.com.hfsframework.admin.restcontroller.AdmFuncionalidadeRestController;
import br.com.hfsframework.base.BaseResourceSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmFuncionalidadeResource.
 */
public class AdmFuncionalidadeResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmFuncionalidade, Long, AdmFuncionalidadeRestController> {

	public AdmFuncionalidadeResource(AdmFuncionalidadeRestController controller, AdmFuncionalidade bean) {
		super(controller, bean);
	}
	*/

	/** The adm funcionalidade. */
	private final AdmFuncionalidade admFuncionalidade;

	/**
	 * Instantiates a new adm funcionalidade resource.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param admFuncionalidade the adm funcionalidade
	 */
	public AdmFuncionalidadeResource(AdmFuncionalidadeRestController controller, Principal principal, AdmFuncionalidade admFuncionalidade) {
		this.admFuncionalidade = admFuncionalidade;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admFuncionalidade.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	/**
	 * Gets the adm funcionalidade.
	 *
	 * @return the adm funcionalidade
	 */
	public AdmFuncionalidade getAdmFuncionalidade() {
		return admFuncionalidade;
	}

	/**
	 * Gets the lista.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param lista the lista
	 * @return the lista
	 */
	public static Resources<AdmFuncionalidadeResource> getLista(AdmFuncionalidadeRestController controller, Principal principal, Iterable<AdmFuncionalidade> lista){
		Stream<AdmFuncionalidade> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmFuncionalidadeResource> listaResource = stream.map(bean -> new AdmFuncionalidadeResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmFuncionalidadeResource>(listaResource);
	}
	
}
