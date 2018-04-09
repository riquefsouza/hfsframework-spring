package br.com.hfsframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
public class Aplicacao {

	//private static final Logger log = LoggerFactory.getLogger(Aplicacao.class);

	public static void main(String[] args) {
		SpringApplication.run(Aplicacao.class);
	}

}
