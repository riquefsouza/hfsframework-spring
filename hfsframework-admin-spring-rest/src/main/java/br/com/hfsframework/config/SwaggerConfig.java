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
//import springfox.documentation.service.AuthorizationCodeGrant;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
//import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@PropertySource("classpath:application.properties")
@Configuration
public class SwaggerConfig  {
    
	private String serviceName = "HFS Framework Admin";

	private String serviceDesc = "HFS Framework Admin using springframework";

	String clientId = "admin-hfsframework";

	String clientSecret = "admin"; //"$2a$10$y7jArsSYCAJjIudWb6zbkuMQZxNFGePkmYJQM0ChB4slgwtUG9RLy"
	
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

	private Predicate<String> postPaths() {
		return regex("/.*");
	}   

	private Predicate<String> springBootActuatorJmxPaths() {
		return regex("^/(?!env|restart|pause|resume|refresh).*$");
	} 

	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(serviceName).description(serviceDesc).build();
	}	
	
	@Bean
	List<GrantType> grantTypes() {
		List<GrantType> grantTypes = new ArrayList<>();
		//TokenRequestEndpoint tokenRequestEndpoint = new TokenRequestEndpoint(oAuthServerUri+"/oauth/authorize", clientId, clientSecret );
        //TokenEndpoint tokenEndpoint = new TokenEndpoint(oAuthServerUri+"/oauth/token", "token");
		//grantTypes.add(new AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint));
        grantTypes.add(new ResourceOwnerPasswordCredentialsGrant(oAuthServerUri+"/oauth/token"));
        return grantTypes;
	}
	
	@Bean
    SecurityScheme oauth() {
        return new OAuthBuilder()
                .name("OAuth2")
                .scopes(scopes())
                .grantTypes(grantTypes())
                .build();
    }
	
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("write", "write and read");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("OAuth2", authorizationScopes));
    }
	
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
