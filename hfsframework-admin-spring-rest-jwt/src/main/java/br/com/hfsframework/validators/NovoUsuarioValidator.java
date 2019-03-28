package br.com.hfsframework.validators;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.service.AdmUsuarioService;
import br.com.hfsframework.dto.input.NovoUsuarioForm;

public class NovoUsuarioValidator implements Validator {

	private AdmUsuarioService admUsuarioService;

	public NovoUsuarioValidator(AdmUsuarioService admUsuarioService) {
		this.admUsuarioService = admUsuarioService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoUsuarioForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoUsuarioForm form = (NovoUsuarioForm) target;

		Optional<AdmUsuario> admUsuario = admUsuarioService.findByLogin(form.getLogin());
		if (admUsuario.isPresent()) {
			errors.rejectValue("login", "", "O login já existe");
		}

	}

}
