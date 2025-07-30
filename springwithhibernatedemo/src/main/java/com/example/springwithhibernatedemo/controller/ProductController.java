package com.example.springwithhibernatedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springwithhibernatedemo.dao.Product;
import com.example.springwithhibernatedemo.dao.ProductDao;

import java.util.List;

@RestController
public class ProductController {
	
	@Autowired
	ProductDao dao;
	
	@GetMapping("/products")
	public List<Product> findAll(){
		return dao.getProducts();
	}
	
	@GetMapping("/product/{pid}")
	public Product findProduct(@PathVariable Integer pid) {
		return dao.findProduct(pid);
	}
	
	@PostMapping("/product")
	public String save(@RequestBody Product product) {
		return dao.saveProduct(product);
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		return dao.deleteProduct(id);
	}
	
}
