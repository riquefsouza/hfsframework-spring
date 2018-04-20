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

import br.com.hfsframework.admin.model.VwAdmLogValor;
import br.com.hfsframework.admin.restcontroller.VwAdmLogValorRestController;
import br.com.hfsframework.base.BaseResourceSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class VwAdmLogValorResource.
 */
public class VwAdmLogValorResource extends ResourceSupport { 

	/*
	extends BaseResourceSupport<VwAdmLogValor, Long, VwAdmLogValorRestController> {

	public VwAdmLogValorResource(VwAdmLogValorRestController controller, VwAdmLogValor bean) {
		super(controller, bean);
	}
	*/

	/** The vw adm log valor. */
	private final VwAdmLogValor vwAdmLogValor;

	/**
	 * Instantiates a new vw adm log valor resource.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param vwAdmLogValor the vw adm log valor
	 */
	public VwAdmLogValorResource(VwAdmLogValorRestController controller, Principal principal, VwAdmLogValor vwAdmLogValor) {
		this.vwAdmLogValor = vwAdmLogValor;

		this.add(linkTo(methodOn(controller.getClass()).search(principal, vwAdmLogValor.getId())).withSelfRel());
		this.add(linkTo(methodOn(controller.getClass()).listar(principal)).withRel(BaseResourceSupport.LIST_ALL));
	}

	/**
	 * Gets the vw adm log valor.
	 *
	 * @return the vw adm log valor
	 */
	public VwAdmLogValor getVwAdmLogValor() {
		return vwAdmLogValor;
	}

	/**
	 * Gets the lista.
	 *
	 * @param controller the controller
	 * @param principal the principal
	 * @param lista the lista
	 * @return the lista
	 */
	public static Resources<VwAdmLogValorResource> getLista(VwAdmLogValorRestController controller, Principal principal, Iterable<VwAdmLogValor> lista){
		Stream<VwAdmLogValor> stream = StreamSupport.stream(lista.spliterator(), false);
		
		List<VwAdmLogValorResource> listaResource = stream.map(bean -> new VwAdmLogValorResource(controller, principal, bean))
				.collect(Collectors.toList());

		return new Resources<VwAdmLogValorResource>(listaResource);
	}
	
}
