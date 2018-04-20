/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework;


import java.io.IOException;
//import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;

import br.com.hfsframework.util.NetUtil;

// TODO: Auto-generated Javadoc
//import br.com.hfsframework.admin.data.AdmUsuarioRepository;
//import br.com.hfsframework.admin.model.AdmUsuario;

/**
 * The Class Aplicacao.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Aplicacao {

	// curl -X POST -vu admin-hfsframework:dd933575-d277-4f08-88d9-2021769b1ca5 http://localhost:8080/oauth/token -H "Accept: application/json" -d "password=admin&username=henrique.souza&grant_type=password&scope=write&client_secret=123456&client_id=admin-hfsframework"
	// curl -v POST http://127.0.0.1:8080/admCargos -H "Authorization: Bearer <oauth_token>""
	
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(Aplicacao.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		SpringApplication.run(Aplicacao.class);
		
		log.info("------------------------------------------------------------------------");
		log.info("HFS Admin SpringFramework REST");
		log.info("Desenvolvido por Henrique Figueiredo de Souza");
		log.info("Versão 1.0 - 2018");
		log.info("------------------------------------------------------------------------");
		
		NetUtil.printIpHost();
	}

	/**
	 * Cors filter.
	 *
	 * @param origin the origin
	 * @return the filter registration bean
	 */
	// CORS
	@Bean
	FilterRegistrationBean<Filter> corsFilter(
			@Value("${tagit.origin}") String origin) {
			//@Value("${tagit.origin:http://localhost:9000}") String origin) {
		return new FilterRegistrationBean<Filter>(new Filter() {
			public void doFilter(ServletRequest req, ServletResponse res,
					FilterChain chain) throws IOException, ServletException {
				HttpServletRequest request = (HttpServletRequest) req;
				HttpServletResponse response = (HttpServletResponse) res;
				String method = request.getMethod();
				// this origin value could just as easily have come from a database
				response.setHeader("Access-Control-Allow-Origin", origin);
				response.setHeader("Access-Control-Allow-Methods",
						"POST,GET,OPTIONS,DELETE");
				response.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
				response.setHeader("Access-Control-Allow-Credentials", "true");
				response.setHeader(
						"Access-Control-Allow-Headers",
						"Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
				if ("OPTIONS".equals(method)) {
					response.setStatus(HttpStatus.OK.value());
				}
				else {
					chain.doFilter(req, res);
				}
			}

			public void init(FilterConfig filterConfig) {
			}

			public void destroy() {
			}
		});
	}
/*
	@Bean
	CommandLineRunner init(AdmUsuarioRepository admUsuarioRepository) {
		return (evt) -> Arrays.asList(
				"henrique.souza,rafael.caneca".split(","))
				.forEach(
						a -> {
							admUsuarioRepository.save(new AdmUsuario(a,""));
						});
	}
		*/
	
/*
keytool -genkey -alias hfsframework -keyalg RSA -keystore src/main/resources/tomcat.keystore
Informe a senha da área de armazenamento de chaves:
Informe novamente a nova senha:
Qual é o seu nome e o seu sobrenome?
  [Unknown]:  henrique souza
Qual é o nome da sua unidade organizacional?
  [Unknown]:  DIREM
Qual é o nome da sua empresa?
  [Unknown]:  TRTRJ
Qual é o nome da sua Cidade ou Localidade?
  [Unknown]:  RJ
Qual é o nome do seu Estado ou Município?
  [Unknown]:  RJ
Quais são as duas letras do código do país desta unidade?
  [Unknown]:  BR
CN=henrique souza, OU=DIREM, O=TRTRJ, L=RJ, ST=RJ, C=BR Está correto?
  [não]:  sim

Informar a senha da chave de <hfsframework>
        (RETURN se for igual à senha da área do armazenamento de chaves):
Informe novamente a nova senha:
	
 */
}
