package com.pro.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	    		//title
	    		"PDN-Notes", 
	    		//description
	    		"Pro Dev Network Notes", 
	    		//version
	    		"v0.0.0", 
	    		//termsOfServiceUrl
	    		"Terms of service", 
	    		//contact
	    		new Contact("Prodapt Solutions", "http://www.prodapt.com", "arunkumar.a@prodapt.com"), 
	    		//license
	    		"License", 
	    		//licenseUrl
	    		"API license URL", 
	    		//vendorExtensions
	    		Collections.emptyList());
	}

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
		      new HashSet<String>(Arrays.asList("application/json"));

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("PDN-Notes").select()
				.apis(RequestHandlerSelectors.basePackage("com.pro.app.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
		        .consumes(DEFAULT_PRODUCES_AND_CONSUMES);		
		        
		  }

}
