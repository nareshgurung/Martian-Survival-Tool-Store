package net.revature;

import java.util.Iterator;
import java.util.List;

import net.revature.models.Categories;
import net.revature.service.AllFromATable;

public class core {
	public static void main(String[] args) {

		List<Categories> cats = new AllFromATable().fromCategories();
		
		for(Iterator<Categories> iterator = cats.iterator(); iterator.hasNext();) {
			Categories cat = iterator.next();
			System.out.println(cat.toString());
		}
	}
}
