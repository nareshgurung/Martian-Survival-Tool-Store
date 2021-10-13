package net.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.revature.models.Products;
import net.revature.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("productsController")
@RequestMapping("/products")
public class ProductsController {

	
	private ProductService pService;
	
	@Autowired
	public ProductsController(ProductService pService) {
		this.pService = pService;
	}

	@GetMapping(path="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Products>> getAll(){
		return new ResponseEntity<List<Products>>(this.pService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/all/{catID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Products>> getListByID(@PathVariable String catID) {
		return new ResponseEntity<List<Products>>(this.pService.findById(catID), HttpStatus.OK); 
	}

	@GetMapping(path="/id/{catID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Products>> getProductByID(@PathVariable String catID) {
		return new ResponseEntity<List<Products>>(this.pService.findOneById(catID), HttpStatus.OK); 
	}
}
