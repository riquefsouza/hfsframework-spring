package br.com.hfsframework.admin.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisualizarArqLogServidorController {

	@GetMapping("/visualizarArqLogServidor")
	public String pagina() {
		return "/private/admin/visualizarArqLogServidor";
	}

}
