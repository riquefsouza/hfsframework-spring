package br.com.hfsframework.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailsService;
	private TokenAuthenticationService tokenAuthenticationService;
	

	public SecurityConfiguration(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
		this.tokenAuthenticationService = new TokenAuthenticationService("tooManySecrets", userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		
		StatelessLoginFilter statelessLoginFilter = new StatelessLoginFilter("/api/login", 
				tokenAuthenticationService, userDetailsService, authenticationManager());
		
		StatelessAuthenticationFilter statelessAuthenticationFilter = 
				new StatelessAuthenticationFilter(tokenAuthenticationService);
		
		http.authorizeRequests()
		.antMatchers("/api/public/**").permitAll()
		.antMatchers(HttpMethod.POST, "/api/login").permitAll()
		.antMatchers("/swagger-ui.html").permitAll()
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/swagger-resources/**").permitAll()
		.antMatchers("/v2/api-docs/**").permitAll()
		.antMatchers("/configuration/**").permitAll()
		.antMatchers("/usuarios/**").permitAll()
		.and()
		.csrf().disable()	
		.addFilterBefore(statelessLoginFilter, UsernamePasswordAuthenticationFilter.class)		
		.addFilterBefore(statelessAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public TokenAuthenticationService tokenAuthenticationService() {
        return tokenAuthenticationService;
    }    
}
