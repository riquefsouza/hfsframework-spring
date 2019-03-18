/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceServerConfig.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */
    @Override 
    public void configure(HttpSecurity http) throws Exception {
         // @formatter:off
         http
         .requestMatchers().antMatchers(
        		 "/admMenus", "/admMenus/**",
        		 "/admPaginas", "/admPaginas/**",
        		 "/admParametroCategorias", "/admParametroCategorias/**",
        		 "/admParametros", "/admParametros/**",
        		 "/admPerfis", "/admPerfis/**",
        		 "/admUsuarios", "/admUsuarios/**",
        		 "/vwAdmLogs", "/vwAdmLogs/**",
        		 "/vwAdmLogValores", "/vwAdmLogValores/**")    
         //.requestMatchers().antMatchers("*")
         .and()
         .authorizeRequests().anyRequest().access("#oauth2.hasScope('write')");
         // @formatter:on
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer)
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
         resources.resourceId(OAuth2Configuration.RESOURCE_ID);
    }


}
