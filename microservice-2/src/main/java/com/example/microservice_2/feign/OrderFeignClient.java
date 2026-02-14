package com.example.microservice_2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservice_2.dto.Product;

@FeignClient(name = "microservice1")
public interface OrderFeignClient {

	@GetMapping("/api/products/{id}")
	Product getProductById(@PathVariable Long id);
}
