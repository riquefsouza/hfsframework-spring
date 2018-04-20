/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.security;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.hfsframework.util.exceptions.UserNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class UserNotFoundControllerAdvice.
 */
@ControllerAdvice
public class UserNotFoundControllerAdvice {

	/**
	 * User not found exception handler.
	 *
	 * @param ex the ex
	 * @return the vnd errors
	 */
	@ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	VndErrors userNotFoundExceptionHandler(UserNotFoundException ex) {
		return new VndErrors("error", ex.getMessage());
	}

}
