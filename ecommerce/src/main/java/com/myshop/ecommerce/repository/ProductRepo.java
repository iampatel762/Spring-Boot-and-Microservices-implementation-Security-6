package com.myshop.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.ecommerce.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer>{

    @Query("SELECT p FROM Product p WHERE "+
        " LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword,'%')) OR "+
            " LOWER(p.description) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            " LOWER(p.brand) LIKE LOWER(CONCAT('%',:keyword,'%')) OR "+
            " LOWER(p.category) LIKE LOWER(CONCAT('%',:keyword,'%'))"
    )
    public List<Product> searchProduct(String keyword);
}
