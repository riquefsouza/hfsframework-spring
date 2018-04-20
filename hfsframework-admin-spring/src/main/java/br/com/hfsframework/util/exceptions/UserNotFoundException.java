/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.util.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class UserNotFoundException.
 */
@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

	/**
	 * Instantiates a new user not found exception.
	 *
	 * @param userId the user id
	 */
	public UserNotFoundException(String userId) {
		super("Não foi possível encontrar usuário: " + userId);
	}

}
