package net.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.models.Categories;
import net.revature.repository.CategoryRepository;

@Service("cService")
public class CategoryService {
	
	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		
		this.categoryRepository = categoryRepository;
		System.out.println("categories works");
	}
	
	public List<Categories> findAll(){
		return this.categoryRepository.getAll();
	}

	public Categories getByUsername(String id) {
		return this.categoryRepository.getByCategoryID(id);
	}
}
