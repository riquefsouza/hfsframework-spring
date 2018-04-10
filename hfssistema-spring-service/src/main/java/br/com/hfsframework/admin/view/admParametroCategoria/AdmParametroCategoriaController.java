package br.com.hfsframework.admin.view.admParametroCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.admin.service.AdmParametroCategoriaService;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

@Controller
@TratamentoErrosEsperados
@RequestMapping("/admParametroCategoriaMB")
public class AdmParametroCategoriaController {
	
	@Autowired
	private AdmParametroCategoriaService admParametroCategoriaService;

	@GetMapping("/listar")
	public String paginaListar() {
		return "/private/admin/admParametroCategoria/listarAdmParametroCategoria";
	}

	@GetMapping("/editar")
	public String paginaEditar() {
		return "/private/admin/admParametroCategoria/editarAdmParametroCategoria";
	}
	
	@ModelAttribute("listaCategorias")
    public Iterable<AdmParametroCategoria> listaCategorias() {
        return admParametroCategoriaService.findAll();
    }
}
