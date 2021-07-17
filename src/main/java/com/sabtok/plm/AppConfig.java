package com.sabtok.plm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AppConfig {

	@Value("${cross-origin}")
	private String crossOrigin;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				System.out.println("Cross Origin"+crossOrigin);
				//registry.addMapping("/**").allowedOrigins("http://localhost:4000");
				registry.addMapping("/**").allowedOrigins(crossOrigin);
			}
		};
	}
}
