/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admParametroCategoria;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.admin.service.AdmParametroCategoriaService;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmParametroCategoriaController.
 */
@Controller
@TratamentoErrosEsperados
@RequestMapping("/admParametroCategoriaMB")
public class AdmParametroCategoriaController {

	/** The service. */
	@Autowired
	private AdmParametroCategoriaService service;

	private AdmParametroCategoria bean;
	
	/**
	 * Pagina listar.
	 *
	 * @return the string
	 */
	public String paginaListar() {
		return "/private/admin/admParametroCategoria/listarAdmParametroCategoria";
	}

	/**
	 * Pagina editar.
	 *
	 * @return the string
	 */
	public String paginaEditar() {
		return "/private/admin/admParametroCategoria/editarAdmParametroCategoria";
	}
	
	/*
	@ModelAttribute("bean")
	public AdmParametroCategoria novo() {
		return new AdmParametroCategoria();
	}
	*/
	
	/*
	@ModelAttribute("listaBean")
	public Iterable<AdmParametroCategoria> listaBean() {		
		return service.findAll();
	}
	*/
	
	/**
	 * Listar.
	 *
	 * @return the model and view
	 */
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView(paginaListar());
		Iterable<AdmParametroCategoria> lista = service.findAll();
		mv.addObject("listaBean", lista);
		return mv;
	}

	/**
	 * Incluir.
	 *
	 * @return the model and view
	 */
	@GetMapping("/incluir")
	public ModelAndView incluir() {
		this.bean = new AdmParametroCategoria();		
		ModelAndView mv = new ModelAndView(paginaEditar());
		mv.addObject("bean", this.bean);
		return mv;
	}

	/**
	 * Editar.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<AdmParametroCategoria> bean = service.load(id);		
		ModelAndView mv = new ModelAndView(paginaEditar());
		mv.addObject("bean", bean.get());
		this.bean = bean.get();
		return mv;
	}

	//@PostMapping("/editar/{id}")
	//@RequestMapping(value="/editar", method=RequestMethod.POST)
	/*
	@PostMapping("/salvar")
	public String salvar(AdmParametroCategoria bean) {

		if (bean.getId() == null)
			service.insert(bean);
		else
			service.update(bean);

		return "redirect:/admParametroCategoriaMB/listar";			
	}
	*/
	/*
	@GetMapping("/salvar")
	public ModelAndView getModelo(Model model, HttpServletRequest request) {
		return new ModelAndView(paginaEditar(), "command", model);
	}
	*/
	//Model model, @ModelAttribute("bean") 
	@PostMapping("/salvar")
	public RedirectView salvar(@Valid AdmParametroCategoria obj, 
			BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			//return "redirect:editar/{id}";
			//return new RedirectView("/admParametroCategoriaMB/editar/{id}");
			return new RedirectView("/admParametroCategoriaMB/incluir");
		}
		
		if (bean.getId() == null)
			service.insert(obj);
		else
			service.update(obj);
		
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		
		//return "redirect:/admParametroCategoriaMB/listar";
		return new RedirectView("/admParametroCategoriaMB/listar");
	}

	
	/**
	 * Excluir.
	 *
	 * @param id the id
	 * @return the string
	 */
	@GetMapping("/excluir/{id}")
	public RedirectView excluir(@PathVariable("id") Long id) {
		Optional<AdmParametroCategoria> bean = service.load(id);
		service.delete(bean.get());
		//return "redirect:/admParametroCategoriaMB/listar";
		return new RedirectView("/admParametroCategoriaMB/listar");
	}
}
