package core;
import java.util.Iterator;
import java.util.List;

import getAll.FromCategories;
import net.revature.models.Categories;

public class Driver {

	public static void main(String[] args) {
		List<Categories> cats = FromCategories.getAll();
		
		for(Iterator<Categories> iterator = cats.iterator(); iterator.hasNext();) {
			Categories cat = iterator.next();
			System.out.println(cat.toString());
		}
	}
}
