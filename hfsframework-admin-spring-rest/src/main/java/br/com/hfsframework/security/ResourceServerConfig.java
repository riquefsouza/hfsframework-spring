package br.com.hfsframework.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

    @Override 
    public void configure(HttpSecurity http) throws Exception {
         // @formatter:off
         http
         .requestMatchers().antMatchers(
        		 "/admCargos", "/admCargos/**",
        		 "/admFuncionalidades", "/admFuncionalidades/**",
        		 "/admFuncionarios", "/admFuncionarios/**",
        		 "/admLogColunas", "/admLogColunas/**",
        		 "/admMenus", "/admMenus/**",
        		 "/admPaginas", "/admPaginas/**",
        		 "/admParametroCategorias", "/admParametroCategorias/**",
        		 "/admParametros", "/admParametros/**",
        		 "/admPerfis", "/admPerfis/**",
        		 "/admSetores", "/admSetores/**",
        		 "/admUsuarios", "/admUsuarios/**",
        		 "/vwAdmLogs", "/vwAdmLogs/**",
        		 "/vwAdmLogValores", "/vwAdmLogValores/**")    
         //.requestMatchers().antMatchers("*")
         .and()
         .authorizeRequests().anyRequest().access("#oauth2.hasScope('write')");
         // @formatter:on
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
         resources.resourceId(OAuth2Configuration.RESOURCE_ID);
    }


}
