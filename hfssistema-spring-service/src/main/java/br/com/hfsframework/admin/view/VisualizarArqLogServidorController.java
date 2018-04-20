/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class VisualizarArqLogServidorController.
 */
@Controller
public class VisualizarArqLogServidorController {

	/**
	 * Pagina.
	 *
	 * @return the string
	 */
	@GetMapping("/visualizarArqLogServidor")
	public String pagina() {
		return "/private/admin/visualizarArqLogServidor";
	}

}
