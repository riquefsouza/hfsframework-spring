/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.service.AdmUsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioServicoDetalhes.
 */
@Component
public class UsuarioServicoDetalhes implements UserDetailsService {

	/** The repository. */
	private final AdmUsuarioService admUsuarioService;

	/**
	 * Instantiates a new usuario servico detalhes.
	 *
	 * @param repository the repository
	 */
	@Autowired
	public UsuarioServicoDetalhes(AdmUsuarioService admUsuarioService) {
		this.admUsuarioService = admUsuarioService;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		UserDetails user;
		Optional<AdmUsuario> admUsuario = this.admUsuarioService.findByLogin(name);
		
		if (!admUsuario.isPresent()) {
			throw new UsernameNotFoundException("Usuário ou senha inválidos");
		}
			
		String[] roles = { "USER" };

		//String csenha = DigestUtils.shaHex(senha);
		//String csenha = BCrypt.hashpw("admin", BCrypt.gensalt());
		//$2a$10$y7jArsSYCAJjIudWb6zbkuMQZxNFGePkmYJQM0ChB4slgwtUG9RLy
		
		user = new User(admUsuario.get().getLogin(), admUsuario.get().getSenha(),
				AuthorityUtils.createAuthorityList(roles));
				
		try {
			admUsuarioService.autenticar(admUsuario);
		} catch (Exception e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
		
		return user;
	}

}
