package com.webProject.myapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webProject.myapplication.modal.ProductModal;
import com.webProject.myapplication.services.ProductServices;

@RestController
public class Product {
	@Autowired
	ProductServices services;
	
	@GetMapping("/products")
	public List<ProductModal> getProducts() {
		return services.getProducts();
	}
	@GetMapping("/products/{prodId}")
	public ProductModal getProductById(@PathVariable int prodId ) {
		return services.getProductById(prodId);
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody ProductModal prod) {
		services.addProduct(prod);
	}
	
	@PutMapping("/products")
	public void updateProduct(@RequestBody ProductModal prod) {
		services.updateProduct(prod);
	}
	
	@DeleteMapping("/products/{prodId}")
	public void deleteProduct(@PathVariable int prodId) {
		services.deleteProduct(prodId);
	}
}
