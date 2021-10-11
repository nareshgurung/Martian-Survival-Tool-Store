package net.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.revature.models.Categories;
import net.revature.service.CategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("categoriesController")
@RequestMapping("/categories")
public class CategoriesController {

	private CategoryService cService;

	@Autowired
	public CategoriesController(CategoryService catService){
		this.cService=catService;
	}

	@GetMapping(path="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categories>> getAll(){
		return new ResponseEntity<List<Categories>>(this.cService.findAll(), HttpStatus.OK);
	}
}