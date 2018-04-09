package br.com.hfsframework.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.com.hfsframework.audit.AuditorAwareImpl;

@Configuration
@EnableCaching
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class AplicacaoConfig {

	@Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
