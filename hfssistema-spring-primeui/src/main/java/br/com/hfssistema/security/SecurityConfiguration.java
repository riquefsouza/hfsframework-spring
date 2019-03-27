/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfssistema.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityConfiguration.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

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

		/*
		http.authorizeRequests()
		.antMatchers("/api/public/**").permitAll()
		.antMatchers("/gera/dados").permitAll()
		.antMatchers(HttpMethod.POST, "/api/login").permitAll()
		.antMatchers("/swagger-ui.html").permitAll()
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/swagger-resources/**").permitAll()
		.antMatchers("/v2/api-docs/**").permitAll()
		.antMatchers("/configuration/**").permitAll()
		.antMatchers("/usuarios/**").permitAll()
			.and()
			.csrf().disable()
		*/
		
		http.authorizeRequests()
				.antMatchers("/css/**", "/img/**", "/js/**", "/primeui/**", "/scss/**", "/vendor/**").permitAll()
				//.antMatchers(HttpMethod.GET, "/").permitAll()
				//.antMatchers(HttpMethod.GET, "/listarUsuario").hasRole("ADMIN")
				//.anyRequest().authenticated()
				//.and()
				//.requiresChannel().anyRequest().requiresSecure().and()
				//.requiresChannel().anyRequest().requiresInsecure().and()
			//.requiresChannel().antMatchers("/login*").requiresSecure().and()
			//.formLogin()				
				//.loginPage("/login")
				//.failureUrl("/login?error=401").permitAll()
				//.defaultSuccessUrl("/").and()
			//.httpBasic()
				.and()
			.csrf().disable();
			//.logout()
				//.permitAll()				
				//.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				//.logoutSuccessUrl("/login");
	}

	/*
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.POST, "/**");
	}
	*/
}
