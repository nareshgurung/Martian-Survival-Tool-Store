package net.revature.service;

import java.util.List;

import net.revature.daos.FromCategories;
import net.revature.models.Categories;

public class AllFromATable {
	public List<Categories> fromCategories() {
		List<Categories> lst = FromCategories.getAll("Categories", new Categories());
		return lst;
	}
}
