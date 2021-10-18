package net.revature.junitTest;


import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;


import net.revature.daos.CategoryRepository;
import net.revature.models.Categories;
import net.revature.service.CategoryService;

public class CategoryServiceTest {

	@InjectMocks
	private static CategoryService cServ;
	
	@Mock
	private CategoryRepository cRepo;
	
	{
		MockitoAnnotations.openMocks(this);
		
	}
	
	@BeforeClass
	public static void setUp() {
		cServ = new CategoryService();
	}
	
	@Test
	public void testFindAll() {
		Mockito.when(cServ.findAll()).thenReturn(
				Arrays.asList(
						new Categories(1, "drone"),
						new Categories(2, "equip")
						));
		List<Categories> usr = cServ.findAll();		
		Assert.assertEquals(usr.size(), 2, "list users");
	}
	
	
}
