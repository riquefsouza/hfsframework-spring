/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.hfsframework.AplicacaoBundle;
import br.com.hfsframework.AplicacaoUtil;
import br.com.hfsframework.util.ldap.LdapBundle;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityConfiguration.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/** The user details service. */
	@Autowired
	private UsuarioServicoDetalhes userDetailsService;
	
	/** The aplicacao bundle. */
	@Autowired
	private AplicacaoBundle aplicacaoBundle;
	
	/** The ldap bundle. */
	@Autowired	
	private LdapBundle ldapBundle;
		
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		if (aplicacaoBundle.isHabilitarLDAP()) {
			String surl = ldapBundle.getLdapTipoConexao().toLowerCase()+"://"+ldapBundle.getLdapServer()+":"+ldapBundle.getLdapPorta();
			
			//ldapUserSenha
			
			auth
			.ldapAuthentication()
				.userDnPatterns(ldapBundle.getLdapUserDN())
				.groupSearchBase(ldapBundle.getLdapBaseDN())
				.contextSource()				
					.url(surl)
					.and()
				.passwordCompare()
					//.passwordEncoder(new LdapShaPasswordEncoder())
					.passwordAttribute("userPassword");			
		} else {
			auth
			.userDetailsService(this.userDetailsService)
				.passwordEncoder(AplicacaoUtil.PASSWORD_ENCODER);			
		}
	}
	
	/*
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
             	.username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
    */
	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
				//.antMatchers(HttpMethod.GET, "/").permitAll()
				//.antMatchers(HttpMethod.GET, "/listarUsuario").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				//.requiresChannel().anyRequest().requiresSecure().and()
				//.requiresChannel().anyRequest().requiresInsecure().and()
			//.requiresChannel().antMatchers("/login*").requiresSecure().and()
			.formLogin()				
				.loginPage("/login")
				.failureUrl("/login?error=401").permitAll()
				.defaultSuccessUrl("/").and()
			//.httpBasic()
				//.and()
			//.csrf().disable()
			.logout()
				//.permitAll()				
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login");
	}

	/*
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.POST, "/**");
	}
	*/
}
