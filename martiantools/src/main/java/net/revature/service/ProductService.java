package net.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.daos.ProductRepository;
import net.revature.models.Products;

@Service("pService")
public class ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
		System.out.println("hello from productService!");
	}
	
	public List<Products> findAll(){
		return this.productRepository.getAll();
	}
}
