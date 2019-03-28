package br.com.hfsframework.validators; 

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.hfsframework.dto.input.NovoUsuarioForm;

public class UsuarioESenhaDiferentesValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoUsuarioForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoUsuarioForm form = (NovoUsuarioForm) target;
		if (!form.loginESenhaDiferentes()) {
			errors.rejectValue("login", "", "O login precisa ser diferente da senha");
		}
	}

}
