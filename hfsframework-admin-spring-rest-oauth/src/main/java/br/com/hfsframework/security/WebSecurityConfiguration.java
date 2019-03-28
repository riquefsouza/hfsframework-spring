/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class WebSecurityConfiguration.
 */
@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	/** The user details service. */
	@Autowired
	private UsuarioServicoDetalhes userDetailsService;

	//@Autowired
	//AdmUsuarioService admUsuarioService;

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter#init(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService())
			.passwordEncoder(passwordEncoder());
			//.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	/**
	 * Password encoder.
	 *
	 * @return the b crypt password encoder
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	*/
	
	/**
	 * User details service.
	 *
	 * @return the user details service
	 */
	@Bean
	UserDetailsService userDetailsService() {
		/*
		return (login) -> admUsuarioService
				.findByLogin(login)
				.map(a -> new User(a.getLogin(), a.getSenha(), true, true, true, true,
						AuthorityUtils.createAuthorityList("USER", "write")))
				.orElseThrow(
						() -> new UsernameNotFoundException(login));
						*/
		return this.userDetailsService;
	}
}
