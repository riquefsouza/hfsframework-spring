/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

// TODO: Auto-generated Javadoc
/**
 * The Class OAuth2Configuration.
 */
@Configuration
@EnableResourceServer
@EnableAuthorizationServer
class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

	/** The Constant RESOURCE_ID. */
	public static final String RESOURCE_ID = "hfsframework";

	// This is required for password grants, which we specify below as one of the
	/** The authentication manager. */
	// {@literal authorizedGrantTypes()}.
	@Autowired
	AuthenticationManagerBuilder authenticationManager;

	/* (non-Javadoc)
	 * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer)
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception {
		// Workaround for https://github.com/spring-projects/spring-boot/issues/1801
		endpoints.authenticationManager(new AuthenticationManager() {
			@Override
			public Authentication authenticate(Authentication authentication)
					throws AuthenticationException {
				return authenticationManager.getOrBuild().authenticate(authentication);
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory()
			.withClient("admin-" + RESOURCE_ID)
			.authorizedGrantTypes("password", "authorization_code", "refresh_token")
			.authorities("ROLE_USER")
			.scopes("write")
			.resourceIds(RESOURCE_ID)
			.secret("$2a$10$y7jArsSYCAJjIudWb6zbkuMQZxNFGePkmYJQM0ChB4slgwtUG9RLy");
	}
}