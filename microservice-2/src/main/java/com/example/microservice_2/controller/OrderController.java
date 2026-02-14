package com.example.microservice_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.microservice_2.dto.Product;
import com.example.microservice_2.feign.OrderFeignClient;

@RestController
public class OrderController {

	private RestTemplate restTemplate;
	private WebClient webClient;
	private OrderFeignClient feignClient;
	public OrderController(RestTemplate restTemplate, 
			WebClient.Builder webClientBuilder, OrderFeignClient feignClient) {
		this.webClient = webClientBuilder.build();
		this.restTemplate = restTemplate;
		this.feignClient = feignClient;
	}	
	
	@GetMapping("/orders/product/{id}")
	public Product getOrderById(@PathVariable Long id) {
//	    return restTemplate.getForObject(
//	            "http://microservice1/api/products/" + id,
//	            Product.class
//	        );
		
//		return webClient.get()
//		        .uri("http://microservice1/api/products/" + id)
//		        .retrieve()
//		        .bodyToMono(Product.class)
//		        .block();
		
		return feignClient.getProductById(id);
		
	}
}
