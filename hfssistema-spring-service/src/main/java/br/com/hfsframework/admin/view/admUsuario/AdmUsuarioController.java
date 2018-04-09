package br.com.hfsframework.admin.view.admUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.hfsframework.admin.service.AdmUsuarioService;

@Controller
//@RequestMapping("/user.htm")
//@SessionAttributes("user")
public class AdmUsuarioController {

	@Autowired
	private AdmUsuarioService admUsuarioService;

	@GetMapping("/listarAdmUsuario")
	public String paginaListar() {
		return "/private/admin/AdmUsuario/listarAdmUsuario";
	}

	@GetMapping("/editarAdmUsuario")
	public String paginaEditar() {
		return "/private/admin/AdmUsuario/editarAdmUsuario";
	}

/*
	@RequestMapping(value = "/editarAdmUsuario", method = RequestMethod.GET)
	public String paginaEditar(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}

		return "/private/admin/AdmUsuario/editarAdmUsuario";
	}
	
	
	@ModelAttribute("countryList")
	public List<Country> populateCountryList() {
		return admUsuarioBC.getAllCountries();
	}
	
	@ModelAttribute("communityList")
	public List<Community> populateCommunityList() {
		return admUsuarioBC.getAllCommunities();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("user") User user) {
		admUsuarioBC.add(user);
		return "redirect:userSuccess.htm";
	}
*/		
}
