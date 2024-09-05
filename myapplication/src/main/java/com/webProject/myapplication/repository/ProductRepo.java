package com.webProject.myapplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webProject.myapplication.controller.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
}
