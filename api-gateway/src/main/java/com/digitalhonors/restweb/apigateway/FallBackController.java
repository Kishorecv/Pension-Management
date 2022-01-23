package com.digitalhonors.restweb.apigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	@RequestMapping("/pensionerDetailFallBack")
	@CircuitBreaker(name = "default")
	public Mono<String> pensionerDetailServiceFallBack(){
		return Mono.just("Pensioner Detail Service is taking too long to respond or is down. Please try again later.");
	}
	
	@RequestMapping("/processPensionFallBack")
	@CircuitBreaker(name = "default")
	public Mono<String> processPensionServiceFallBack(){
		return Mono.just("Process Pension Service is taking too long to respond or is down. Please try again later.");
	}
	

}
