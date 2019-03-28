package br.com.hfsframework.dto.input;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;
import org.springframework.util.Assert;

import br.com.hfsframework.admin.model.AdmUsuario;

public class NovoUsuarioForm {

	@NotBlank
	private String login;
	
	@NotBlank
	private String senha;
	
	@NotBlank
	@URL
	private String urlPerfil;

	public String getUrlPerfil() {
		return urlPerfil;
	}

	public void setUrlPerfil(String urlPerfil) {
		this.urlPerfil = urlPerfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean loginESenhaDiferentes() {
		Assert.notNull(login, "O login não pode ser nulo");
		Assert.notNull(senha, "A senha não pode ser nula");

		return !this.login.equals(senha);
	}

	public AdmUsuario buildNovo() {
		return new AdmUsuario(null, login, senha);
	}

}
