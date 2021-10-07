package core;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import getAll.FromCategories;
import net.revature.models.Categories;
import net.revature.service.UserService;

public class Driver {

	public static void main(String[] args) {
		List<Categories> cats = FromCategories.getAll();
		
		for(Iterator<Categories> iterator = cats.iterator(); iterator.hasNext();) {
			Categories cat = iterator.next();
			System.out.println(cat.toString());
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService ulist= context.getBean("uService", UserService.class);
		
		 System.out.println(ulist.getAllUsers());
	}
}
