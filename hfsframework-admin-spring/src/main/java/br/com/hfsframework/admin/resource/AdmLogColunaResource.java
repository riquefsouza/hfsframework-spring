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

import br.com.hfsframework.admin.model.AdmLogColuna;
import br.com.hfsframework.admin.restcontroller.AdmLogColunaRestController;
import br.com.hfsframework.base.BaseResourceSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmLogColunaResource.
 */
public class AdmLogColunaResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<AdmLogColuna, String, AdmLogColunaRestController> {

	public AdmLogColunaResource(AdmLogColunaRestController controller, AdmLogColuna bean) {
		super(controller, bean);
	}
	*/

	/** The adm log coluna. */
	private final AdmLogColuna admLogColuna;

	/**
	 * Instantiates a new adm log coluna resource.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param admLogColuna the adm log coluna
	 */
	public AdmLogColunaResource(AdmLogColunaRestController controller, Principal principal, AdmLogColuna admLogColuna) {
		this.admLogColuna = admLogColuna;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, admLogColuna.getNome())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	/**
	 * Gets the adm log coluna.
	 *
	 * @return the adm log coluna
	 */
	public AdmLogColuna getAdmLogColuna() {
		return admLogColuna;
	}

	/**
	 * Gets the lista.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param lista the lista
	 * @return the lista
	 */
	public static Resources<AdmLogColunaResource> getLista(AdmLogColunaRestController controller, Principal principal, Iterable<AdmLogColuna> lista){
		Stream<AdmLogColuna> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<AdmLogColunaResource> listaResource = stream.map(bean -> new AdmLogColunaResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<AdmLogColunaResource>(listaResource);
	}
	
}
