package br.com.hfsframework.admin.view.admParametroCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.admin.service.AdmParametroCategoriaService;

@Controller
public class AdmParametroCategoriaController {
	
	@Autowired
	private AdmParametroCategoriaService admParametroCategoriaService;

	@GetMapping("/listarAdmParametroCategoria")
	public String paginaListar() {
		return "/private/admin/admParametroCategoria/listarAdmParametroCategoria";
	}

	@GetMapping("/editarAdmParametroCategoria")
	public String paginaEditar() {
		return "/private/admin/admParametroCategoria/editarAdmParametroCategoria";
	}
	
	@ModelAttribute("listaCategorias")
    public Iterable<AdmParametroCategoria> listaCategorias() {
        return admParametroCategoriaService.findAll();
    }
}
