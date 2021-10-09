package net.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import net.revature.models.Categories;
import net.revature.repository.CategoryRepository;


@Data
@Transactional
@Service("categoryService")
public class CategoryService {
	
	private CategoryRepository categoryRepository;

	@Override
	public String toString() {
		return "CategoryService [categoryRepository=" + categoryRepository + "]";
	}

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	public List<Categories> findAll(){
		return this.categoryRepository.findAll();
	}

}
