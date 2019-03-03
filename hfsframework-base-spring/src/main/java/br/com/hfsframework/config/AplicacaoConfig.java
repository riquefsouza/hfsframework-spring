/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.com.hfsframework.audit.AuditorAwareImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class AplicacaoConfig.
 */
@Configuration
@EnableCaching
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class AplicacaoConfig {

	/**
	 * Auditor provider.
	 *
	 * @return the auditor aware
	 */
	@Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
	
}
