/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.config;

import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabasePostgreSQLConfig.
 */
@Configuration
@Profile("dev-postgresql")
public class DatabasePostgreSQLConfig {
	
	/**
	 * Data source.
	 *
	 * @return the basic data source
	 * @throws URISyntaxException the URI syntax exception
	 */
	@Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        //URI dbUri = new URI(System.getenv("DATABASE_URL"));

        //String username = dbUri.getUserInfo().split(":")[0];
        //String password = dbUri.getUserInfo().split(":")[1];
        //String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();		
		String username = "postgres";
		String password = "abcd1234";
		String dbUrl = "jdbc:postgresql://localhost:5432/hfsbanco_spring";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
}
}
