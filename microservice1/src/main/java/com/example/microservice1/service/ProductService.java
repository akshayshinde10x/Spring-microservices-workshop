package com.example.microservice1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice1.entity.Product;
import com.example.microservice1.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> getAllProducts() {
		return repo.findAll();  // select * from ms1_products
	}
	
	public Product getProductById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Product saveProduct(Product product) {
		return repo.save(product);
	}
}
