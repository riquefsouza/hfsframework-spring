/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0.2
 * @since 2019
 */
package br.com.hfsframework.config;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class AppRepoRestConfigurer implements RepositoryRestConfigurer {

	@Autowired
	private EntityManager em;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		List<Class<?>> listJavaType = em.getMetamodel().getEntities().stream().map(e -> e.getJavaType())
		.collect(Collectors.toList());
		
		Class<?>[] domainTypes = listJavaType.toArray(new Class[0]);
		
		config.exposeIdsFor(domainTypes);
	}
}
