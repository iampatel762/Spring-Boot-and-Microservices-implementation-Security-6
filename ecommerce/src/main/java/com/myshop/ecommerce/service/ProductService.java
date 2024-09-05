package com.myshop.ecommerce.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.ecommerce.model.Product;
import com.myshop.ecommerce.repository.ProductRepo;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;

	public List<Product> getAllProducts() {

		return repo.findAll();

	}

	public Product getProductById(int id) {
		return repo.findById(id).orElse(null);
	}

	public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		product.setImageData(imageFile.getBytes());
		return  repo.save(product);

	}

	public Product updateProduct(int id, Product product, MultipartFile imgFile) throws IOException {
		product.setImageData(imgFile.getBytes());
		product.setImageType(imgFile.getContentType());
		product.setImageName(imgFile.getOriginalFilename());

		return repo.save(product);
	}

	public void deleteProduct(int id) {
		repo.deleteById(id);
	}

	public List<Product> getProductByKeyword(String keyword) {
		return repo.searchProduct(keyword);
	}
}

