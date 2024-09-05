package com.webProject.myapplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webProject.myapplication.modal.ProductModal;
import com.webProject.myapplication.repository.ProductRepo;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepo repo;

	public List<ProductModal> getProducts(){
		return repo.findAll();
	}
	
	public ProductModal getProductById(int prodId) {
		
		return repo.findById(prodId).orElse(new ProductModal(0,"",0));
	}
	
	public void addProduct(ProductModal prod) {
	    repo.save(prod);

	}

	public void updateProduct(ProductModal prod) {
		
		repo.save(prod);

		
	}

	public void deleteProduct(int prodId) {
		
		repo.deleteById(prodId);	
	}
}
