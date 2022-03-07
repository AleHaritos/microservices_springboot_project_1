package com.example.demo.configs;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = @Info(title = "Person service", description = "Person service API", version = "v1"))
public class OpenApiSwagger {
	
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
						.components(new Components())
						.info(new io.swagger.v3.oas.models.info.Info()
								.title("Person service")
								.version("v1")
								.description("Person service API")
								.license(new License()
										.name("Apache 2.0")
										.url("htpp://springdoc.org")));
	}
}
