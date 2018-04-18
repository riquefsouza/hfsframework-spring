package br.com.hfsframework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AplicacaoListener implements ApplicationListener<ServletWebServerInitializedEvent> {

	private static final Logger log = LoggerFactory.getLogger(AplicacaoListener.class);
	
    private int port;
    
	@Override
	public void onApplicationEvent(ServletWebServerInitializedEvent event) {
		port = event.getWebServer().getPort();

		log.info("Porta: " + port);
		/*				
		ServletWebServerApplicationContext c = event.getApplicationContext();

		c.getEnvironment().getSystemEnvironment().forEach((key, value) -> {
			log.info("System Key : " + key + ", System Value : " + value);
		});
		
		c.getEnvironment().getSystemProperties().forEach((key, value) -> {
		    log.info("System Prop Key : " + key + ", System Prop Value : " + value);
		});
		
		log.info("EnvironmentLocalServerPort: " + c.getEnvironment().getProperty("local.server.port"));
		
		getAllKnownProperties(c.getEnvironment()).entrySet()
         .stream()
         .forEach(e -> log.info(e.getKey() + " = " + e.getValue()));
		
		
		*/
		
	}

    public int getPort() {
        return port;
    }
	
    /*
    public static Map<String, Object> getAllKnownProperties(Environment env) {
    	Map<String, Object> rtn = new HashMap<>();
    	if (env instanceof ConfigurableEnvironment) {
    		for (PropertySource<?> propertySource : ((ConfigurableEnvironment) env).getPropertySources()) {
    			if (propertySource instanceof EnumerablePropertySource) {
    				for (String key : ((EnumerablePropertySource<?>) propertySource).getPropertyNames()) {
    					rtn.put(key, propertySource.getProperty(key));
    				}
    			}
    		}
    	}
    	return rtn;
    }
    */    
}
