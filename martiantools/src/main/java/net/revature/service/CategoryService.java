package net.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.daos.CategoryRepository;
import net.revature.models.Categories;

@Service("cService")
public class CategoryService {
	
	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Categories> findAll(){
		return this.categoryRepository.getAll();
	}
}
