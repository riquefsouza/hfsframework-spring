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

import br.com.hfsframework.admin.data.AdmUsuarioRepository;
import br.com.hfsframework.admin.model.AdmUsuario;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioServicoDetalhes.
 */
@Component
public class UsuarioServicoDetalhes implements UserDetailsService {

	/** The repository. */
	private final AdmUsuarioRepository repository;

	/**
	 * Instantiates a new usuario servico detalhes.
	 *
	 * @param repository the repository
	 */
	@Autowired
	public UsuarioServicoDetalhes(AdmUsuarioRepository repository) {
		this.repository = repository;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		UserDetails user;
		Optional<AdmUsuario> admUsuario = this.repository.findByLogin(name);
		
		if (!admUsuario.isPresent()) {
			throw new UsernameNotFoundException("Usuário ou senha inválidos");
		}
			
		String[] roles = { "USER" };

		//String csenha = DigestUtils.shaHex(senha);
		//String csenha = BCrypt.hashpw("admin", BCrypt.gensalt());
		//$2a$10$y7jArsSYCAJjIudWb6zbkuMQZxNFGePkmYJQM0ChB4slgwtUG9RLy
		
		user = new User(admUsuario.get().getLogin(), admUsuario.get().getSenha(),
				AuthorityUtils.createAuthorityList(roles));
		
		return user;
	}

}
