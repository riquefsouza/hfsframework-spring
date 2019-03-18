/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfssistema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// TODO: Auto-generated Javadoc
/**
 * The Class Aplicacao.
 */
@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
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
		log.info("HFS Sistema Spring PrimeUI");
		log.info("Desenvolvido por Henrique Figueiredo de Souza");
		log.info("Versão 1.0.2 - 2019");
		log.info("------------------------------------------------------------------------");
		
		//NetUtil.printIpHost();
	}
	
}
