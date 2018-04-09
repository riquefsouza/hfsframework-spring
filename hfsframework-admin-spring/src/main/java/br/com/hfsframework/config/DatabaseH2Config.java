package br.com.hfsframework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev-h2")
public class DatabaseH2Config {

}
