package br.com.hfsframework.security;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.hfsframework.admin.data.AdmUsuarioRepository;
import br.com.hfsframework.admin.model.AdmUsuario;

@Component
public class UsuarioServicoDetalhes implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(UsuarioServicoDetalhes.class);
	
	@Autowired
	private AdmUsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		UserDetails user;
		Optional<AdmUsuario> admUsuario = this.repository.findByLogin(name);
		
		if (!admUsuario.isPresent()) {
			log.info(" ====> Usuário ou senha inválidos");
			
			throw new UsernameNotFoundException("Usuário ou senha inválidos");
		} else {
			log.info("LOGIN: " + admUsuario.get().getLogin());
			log.info("SENHA: " + admUsuario.get().getSenha());
		}
			
		String[] roles = { "USER", "write" };

		//String csenha = DigestUtils.shaHex(senha);
		//String csenha = BCrypt.hashpw("admin", BCrypt.gensalt()); 
		
		user = new User(admUsuario.get().getLogin(), admUsuario.get().getSenha(), true, true, true, true,
				AuthorityUtils.createAuthorityList(roles));

		return user;
	}

}
