package br.com.hfsframework.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import br.com.hfsframework.security.UserDetailsVO;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@PropertySource("classpath:application.properties")
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket swaggerSettings() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().pathMapping("/")
				.ignoredParameterTypes(UserDetailsVO.class)
				.globalOperationParameters(Arrays.asList(new ParameterBuilder().name("X-AUTH-TOKEN")
						.description("Description of header").modelRef(new ModelRef("string"))
						.parameterType("header").required(false).build()));
	}	
	

}
