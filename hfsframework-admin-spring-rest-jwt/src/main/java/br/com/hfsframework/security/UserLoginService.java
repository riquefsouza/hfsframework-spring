package br.com.hfsframework.security;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.service.AdmUsuarioService;

@Component
public class UserLoginService implements UserDetailsService {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(UserLoginService.class);
	
	private final AdmUsuarioService admUsuarioService;

	@Autowired
	public UserLoginService(AdmUsuarioService admUsuarioService) {
		this.admUsuarioService = admUsuarioService;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		//UserDetails user;
		UserDetailsVO userVO;
		Optional<AdmUsuario> admUsuario = this.admUsuarioService.findByLogin(name);
		
		if (!admUsuario.isPresent()) {
			log.info(" ====> Usuário ou senha inválidos");
			
			throw new UsernameNotFoundException("Usuário ou senha inválidos");
		} else {
			log.info("LOGIN: " + admUsuario.get().getLogin());
			log.info("SENHA: " + admUsuario.get().getSenha());
		}
			
		//String[] roles = { "USER", "write" };

		//String csenha = DigestUtils.shaHex(senha);
		//String csenha = BCrypt.hashpw("admin", BCrypt.gensalt()); 
		
		/*
		user = new User(admUsuario.get().getLogin(), admUsuario.get().getSenha(), 
				true, true, true, true,
				AuthorityUtils.createAuthorityList(roles));
		 */
		
		userVO = new UserDetailsVO(admUsuario.get().getLogin(), admUsuario.get().getSenha());
		
		return userVO;
	}

}
