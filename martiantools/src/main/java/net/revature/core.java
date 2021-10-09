package net.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.revature.service.CategoryService;

public class core {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		CategoryService catService = context.getBean("categoryService", CategoryService.class);
		
		System.out.println(catService.findAll());
	}
}
