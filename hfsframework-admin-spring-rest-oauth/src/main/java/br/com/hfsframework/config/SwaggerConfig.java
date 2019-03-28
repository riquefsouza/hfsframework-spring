/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.config;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// TODO: Auto-generated Javadoc
/**
 * The Class SwaggerConfig.
 */
@EnableSwagger2
@PropertySource("classpath:application.properties")
@Configuration
public class SwaggerConfig  {
    
	/** The service name. */
	private String serviceName = "HFS Framework Admin";

	/** The service desc. */
	private String serviceDesc = "HFS Framework Admin using springframework";

	/** The client id. */
	String clientId = "admin-hfsframework";

	/** The client secret. */
	String clientSecret = "admin"; //"$2a$10$y7jArsSYCAJjIudWb6zbkuMQZxNFGePkmYJQM0ChB4slgwtUG9RLy"
	
	/** The o auth server uri. */
	//@Value("http://${server.address}:${server.port}")
	@Value("${oauth.server.uri}:${server.port}")
	String oAuthServerUri; // = "http://localhost:8080";
	
/*
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				//.pathProvider(pathProvider())
                //.host(hostName)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.hfsframework"))
				//.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				//.paths(regex("/api.*"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaInfo())
                .securitySchemes(newArrayList(oauth()));
                //.securitySchemes(newArrayList(securitySchema()))
                //.securityContexts(newArrayList(securityContext()));
	}

	@SuppressWarnings("rawtypes")
	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo(
				"HFS Framework Admin", 
				"HFS Framework Admin using springframework", 
				"1.0",
				"Terms of Service",
				new Contact("Henrique F. de Souza", 
						"https://www.linkedin.com/in/henrique-figueiredo-293b4774/",
						"riquefsouza@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licesen.html", 
				new ArrayList<VendorExtension>());

		return apiInfo;
	}
*/
	
	/**
 * Posts api.
 *
 * @return the docket
 */
@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("HFSFramework Admin Spring Restful")
				.apiInfo(apiInfo()).select().paths(postPaths())
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))	
				.paths(springBootActuatorJmxPaths())
				.build()		
				.securitySchemes(newArrayList(oauth()))
				//.securitySchemes(Collections.singletonList(oauth()));
				.securityContexts(newArrayList(securityContext()));
	}

	/**
	 * Post paths.
	 *
	 * @return the predicate
	 */
	private Predicate<String> postPaths() {
		return regex("/.*");
	}   

	/**
	 * Spring boot actuator jmx paths.
	 *
	 * @return the predicate
	 */
	private Predicate<String> springBootActuatorJmxPaths() {
		return regex("^/(?!env|restart|pause|resume|refresh).*$");
	} 

	
	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(serviceName).description(serviceDesc).build();
	}	
	
	/**
	 * Grant types.
	 *
	 * @return the list
	 */
	@Bean
	List<GrantType> grantTypes() {
		List<GrantType> grantTypes = new ArrayList<>();
		//TokenRequestEndpoint tokenRequestEndpoint = new TokenRequestEndpoint(oAuthServerUri+"/oauth/authorize", clientId, clientSecret );
        //TokenEndpoint tokenEndpoint = new TokenEndpoint(oAuthServerUri+"/oauth/token", "token");
		//grantTypes.add(new AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint));
        grantTypes.add(new ResourceOwnerPasswordCredentialsGrant(oAuthServerUri+"/oauth/token"));
		//grantTypes.add(new ClientCredentialsGrant(oAuthServerUri+"/oauth/token"));
		
		//LoginEndpoint loginEndpoint = new LoginEndpoint(url);
		//grantTypes.add(new ImplicitGrant(loginEndpoint, tokenName));
				
        return grantTypes;
	}
	
	/**
	 * Oauth.
	 *
	 * @return the security scheme
	 */
	@Bean
    SecurityScheme oauth() {
        return new OAuthBuilder()
                .name("OAuth2")
                .scopes(scopes())
                .grantTypes(grantTypes())
                .build();
    }
	
    /**
     * Security context.
     *
     * @return the security context
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    /**
     * Default auth.
     *
     * @return the list
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("write", "write and read");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("OAuth2", authorizationScopes));
    }
	
	/**
	 * Scopes.
	 *
	 * @return the list
	 */
	private List<AuthorizationScope> scopes() {
		List<AuthorizationScope> list = new ArrayList<>();
		list.add(new AuthorizationScope("write", "write and read"));
		/*
		list.add(new AuthorizationScope("read", "read only"));		
		list.add(new AuthorizationScope("read_scope","Grants read access"));
		list.add(new AuthorizationScope("write_scope","Grants write access"));
		list.add(new AuthorizationScope("admin_scope","Grants read write and delete access"));
		*/
		return list;
    }	

	/**
	 * Security info.
	 *
	 * @return the security configuration
	 */
	@Bean
    public SecurityConfiguration securityInfo() {
		return SecurityConfigurationBuilder.builder()
		        .clientId(clientId)
		        .clientSecret(clientSecret)
		        .scopeSeparator(" ")
		        .useBasicAuthenticationWithAccessCodeGrant(true)
		        .build();
	}

}
