/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving aplicacao events.
 * The class that is interested in processing a aplicacao
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAplicacaoListener<code> method. When
 * the aplicacao event occurs, that object's appropriate
 * method is invoked.
 *
 * @see AplicacaoEvent
 */
@Component
public class AplicacaoListener implements ApplicationListener<ServletWebServerInitializedEvent> {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AplicacaoListener.class);
	
    /** The port. */
    private int port;
    
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
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

    /**
     * Gets the port.
     *
     * @return the port
     */
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
