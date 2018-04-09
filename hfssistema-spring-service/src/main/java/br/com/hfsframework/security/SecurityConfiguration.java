package br.com.hfsframework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.hfsframework.AplicacaoBundle;
import br.com.hfsframework.AplicacaoUtil;
import br.com.hfsframework.util.ldap.LdapBundle;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioServicoDetalhes userDetailsService;
	
	@Autowired
	private AplicacaoBundle aplicacaoBundle;
	
	@Autowired	
	private LdapBundle ldapBundle;
		
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
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				//.antMatchers("/built/**", "/main.css").permitAll()
				.antMatchers("/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				//.defaultSuccessUrl("/", true)
				.loginPage("/login")
				.permitAll()
				.and()
			//.httpBasic()
				//.and()
			//.csrf().disable()
			.logout()
				//.permitAll()
				.logoutSuccessUrl("/");
	}

}
