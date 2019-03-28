package br.com.hfsframework.restcontroller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hfsframework.admin.service.AdmUsuarioService;
import br.com.hfsframework.dto.input.NovoUsuarioForm;
import br.com.hfsframework.validators.NovoUsuarioValidator;
import br.com.hfsframework.validators.UsuarioESenhaDiferentesValidator;

@RestController
public class UsuarioRestController {

	@Autowired
	private AdmUsuarioService admUsuarioService;
	
	@InitBinder("novoUsuarioForm")
	public void init(WebDataBinder binder) {
		binder.addValidators(new UsuarioESenhaDiferentesValidator(), new NovoUsuarioValidator(admUsuarioService));
	}

	
	@PostMapping("/usuarios")
	@Transactional
	public HttpEntity<?> novo(@Valid @RequestBody NovoUsuarioForm form) {
		
		admUsuarioService.insert(form.buildNovo());
		return ResponseEntity.ok().build();
	}

}
