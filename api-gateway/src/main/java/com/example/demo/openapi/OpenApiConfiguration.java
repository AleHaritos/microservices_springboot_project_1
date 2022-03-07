package com.example.demo.openapi;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class OpenApiConfiguration {

	@Bean
	@Lazy(false)
	public List<GroupedOpenApi> apis(SwaggerUiConfigParameters config, RouteDefinitionLocator locator) {
		
		var definitions = locator.getRouteDefinitions().collectList().block();
		definitions
				.stream()
				.filter(x -> x.getId().matches(".*-service"))
				.forEach(x -> {
					String name = x.getId();
					config.addGroup(name.replace("-service", ""));
					GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();	
				});
		
		return new ArrayList<>();
	}
	
}
