package br.com.hfsframework.admin.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlterarSenhaController {

	@GetMapping("/alterarSenha")
	public String pagina() {
		return "/private/alterarSenha";
	}

}
