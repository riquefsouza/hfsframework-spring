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
 * The Class AlterarSenhaController.
 */
@Controller
public class AlterarSenhaController {

	/**
	 * Pagina.
	 *
	 * @return the string
	 */
	@GetMapping("/alterarSenha")
	public String pagina() {
		return "/private/alterarSenha";
	}

}
