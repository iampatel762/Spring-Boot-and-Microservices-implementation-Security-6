package com.myshop.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Product")
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="brand")
	private String brand;

	@Column(name="price")
	private BigDecimal price;

	@Column(name="category")
	private String category;

	@Column(name="releaseDate")
//	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private Date releaseDate;

	@Column(name="productAvailable")
	private boolean productAvailable;

	@Column(name="stockQuantity")
	private int stockQuantity;

	@Column(name = "imageName")
	private String imageName;

	@Column(name = "imageType")
	private String imageType;

	@Lob
	@Column(name = "imageData")
	private  byte[] imageData;
}
