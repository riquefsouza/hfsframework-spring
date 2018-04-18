package br.com.hfsframework.util;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

public final class PropUtil implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(PropUtil.class);

	private static void printSources(ConfigurableEnvironment env) {
		log.info("---- property sources ----");
		for (PropertySource<?> propertySource : env.getPropertySources()) {
			log.info("name =  " + propertySource.getName() + 
					"\nsource = " + propertySource.getSource().getClass()
					+ "\n");
		}
	}

	private static void printMap(Map<?, ?> map) {
		map.entrySet().stream().forEach(e -> log.info(e.getKey() + " = " + e.getValue()));

	}

	public static void printProperties() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		ConfigurableEnvironment env = context.getEnvironment();
		printSources(env);
		log.info("---- System properties -----");
		printMap(env.getSystemProperties());
		log.info("---- System Env properties -----");
		printMap(env.getSystemEnvironment());
		context.close();
	}
}
