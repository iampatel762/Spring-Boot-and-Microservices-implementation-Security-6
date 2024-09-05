package com.myshop.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myshop.ecommerce.model.Product;
import com.myshop.ecommerce.service.ProductService;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService service;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		Product product = service.getProductById(id);
		if(product != null)
			return new ResponseEntity<>(product,HttpStatus.OK);
		else
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
		try{
			Product product1 = service.addProduct(product,imageFile);
			return new ResponseEntity<>(product1,HttpStatus.CREATED);
		}
		catch (Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("product/{productId}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
		Product product = service.getProductById(productId);
		byte[] imgFile = product.getImageData();
		return ResponseEntity.ok()
				.contentType(MediaType.valueOf(product.getImageType()))
				.body(imgFile);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Product product,@RequestPart MultipartFile imageFile){
        Product product1 = null;
        try {
            product1 = service.updateProduct(id,product,imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (product1 !=null){
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("updated",HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		Product product = service.getProductById(id);
		if(product !=null){
			service.deleteProduct(id);
			return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("failed to submit",HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/products/search")
	public ResponseEntity<List<Product>> getProductByKeyword(@RequestParam String keyword){
		List<Product> products = service.getProductByKeyword(keyword);
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
}







