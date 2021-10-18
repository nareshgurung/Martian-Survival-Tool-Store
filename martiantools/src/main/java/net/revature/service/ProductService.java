package net.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.checkData.CheckWrongData;
import net.revature.daos.ProductRepository;
import net.revature.models.Products;

@Service("pService")
public class ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Products> findAll(){
		return this.productRepository.getAll();
	}
	
	public List<Products> findById(String id){
		if(!CheckWrongData.canParseAsInteger(id)) {
			return null;
		}
		return this.productRepository.getByCategoryID(id);
	}

	public Products findOneById(int catID) {
		return this.productRepository.getByProductID(catID);
	}
}
