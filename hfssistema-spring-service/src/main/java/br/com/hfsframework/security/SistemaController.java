package br.com.hfsframework.security;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.service.AdmUsuarioService;
import br.com.hfsframework.security.model.UsuarioVO;

@RestController
public class SistemaController {

	@Autowired
	private AdmUsuarioService admUsuarioService;

	@RequestMapping(value = "/sistemaMB", method = RequestMethod.GET)
	public UsuarioVO sistemaMB(HttpServletRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";

	    //ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		//String ipAddress = attr.getRequest().getHeader("X-FORWARDED-FOR");
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			//ipAddress = attr.getRequest().getRemoteAddr();
			ipAddress = request.getRemoteAddr();
		}
		
		
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		Optional<AdmUsuario> admUsuario = admUsuarioService.findByLogin(username);

		UsuarioVO usu = new UsuarioVO();

		if (admUsuario.isPresent()){
			usu.setLogin(admUsuario.get().getLogin());
			usu.setMatricula(admUsuario.get().getId());
			usu.setIp(ipAddress);
			usu.setCpf(admUsuario.get().getCpf());
			usu.setData(admUsuario.get().getData());
			usu.setEmail(admUsuario.get().getEmail());
			usu.setNome(admUsuario.get().getNome());			
		}
		
		return usu;
	}
}