package com.ceceg.smaffy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class SmaffyApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SmaffyApplication.class, args);
	}
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry){
//		registry.addResourceHandler("/**")
//				.addResourceLocations("classpath:/static/")
//				.addResourceLocations("smaffy/src/main/resources/")
//				.addResourceLocations("classpath:/resources/")
//				.addResourceLocations("classpath:/public/")
//				.addResourceLocations("file:build/");
//	}

}
