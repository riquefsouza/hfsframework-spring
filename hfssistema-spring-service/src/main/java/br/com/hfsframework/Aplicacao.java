package br.com.hfsframework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import br.com.hfsframework.util.NetUtil;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
public class Aplicacao {

	private static final Logger log = LoggerFactory.getLogger(Aplicacao.class);

	public static void main(String[] args) {
		SpringApplication.run(Aplicacao.class);
		
		log.info("------------------------------------------------------------------------");
		log.info("HFS Sistema Spring Service");
		log.info("Desenvolvido por Henrique Figueiredo de Souza");
		log.info("Versão 1.0 - 2018");
		log.info("------------------------------------------------------------------------");
		
		NetUtil.printIpHost();
	}

}
