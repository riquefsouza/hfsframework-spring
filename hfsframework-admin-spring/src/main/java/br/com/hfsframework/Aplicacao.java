/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.hfsframework.util.NetUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class Aplicacao.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Aplicacao {

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
		log.info("HFS Admin SpringFramework");
		log.info("Desenvolvido por Henrique Figueiredo de Souza");
		log.info("Versão 1.0 - 2018");
		log.info("------------------------------------------------------------------------");

		NetUtil.printIpHost();	
	}
	
}
