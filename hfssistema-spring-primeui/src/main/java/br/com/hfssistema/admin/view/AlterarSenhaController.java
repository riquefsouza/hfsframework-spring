/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2019
 */
package br.com.hfssistema.admin.view;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.hfsframework.base.view.BaseViewController;

/**
 * The Class AlterarSenhaController.
 */
@Controller
@RequestMapping("/alterarSenhaMB")
public class AlterarSenhaController extends BaseViewController implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pagina listar. */
	private String paginaListar; 
	
	public AlterarSenhaController() {
		this.paginaListar = "/private/alterarSenha";
	}

	@GetMapping("/listar")
	public String listar() {
		return getPaginaListar();
	}
	
	/**
	 * Pega o the pagina listar.
	 *
	 * @return o the pagina listar
	 */
	public String getPaginaListar() {
		return paginaListar;
	}

	/**
	 * Cancelar edicao.
	 *
	 * @return the string
	 */
	public String cancelarEdicao() {
		return getPaginaListar();
	}
	
	/**
	 * Cancelar.
	 *
	 * @return the string
	 */
	public String cancelar() {
		return getPaginaDesktop();
	}
	
}
