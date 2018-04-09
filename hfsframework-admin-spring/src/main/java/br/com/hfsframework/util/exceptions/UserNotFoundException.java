package br.com.hfsframework.util.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String userId) {
		super("Não foi possível encontrar usuário: " + userId);
	}

}
