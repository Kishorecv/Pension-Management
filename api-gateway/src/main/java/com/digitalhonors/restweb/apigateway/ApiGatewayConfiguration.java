package com.digitalhonors.restweb.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("MyHeader", "MyURI").addRequestParameter("Param", "MyValue"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/pensioner-detail/**").uri("lb://pensioner-detail"))
				.route(p -> p.path("/process-pension/**").uri("lb://process-pension"))
				/*.route(p -> p.path("/pensioner-detail/**")
						.filters(f -> f.rewritePath(
								"/pensioner-detail/(?<segment>.*)", 
								"/pensioner-detail/${segment}"))
						.uri("lb://pensionerDetailFallBack"))
				.route(p -> p.path("/process-pension/**")
						.filters(f -> f.rewritePath(
								"/process-pension/(?<segment>.*)", 
								"/process-pension/${segment}"))
						.uri("lb://processPensionFallBack"))*/
				.build();	
	}

}
