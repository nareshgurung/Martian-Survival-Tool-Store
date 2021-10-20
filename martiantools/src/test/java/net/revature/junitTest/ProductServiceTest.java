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

import net.revature.daos.ProductRepository;
import net.revature.models.Products;
import net.revature.service.ProductService;

public class ProductServiceTest {
	
	@InjectMocks
	private  static ProductService pService;
	
	
	@Mock
	private ProductRepository pRepo;
	
	{
		MockitoAnnotations.openMocks(this);
	}

	@BeforeClass
	public static void setUp(){
		pService = new ProductService();
	}
	
	@Test 
	public void testProductAll() {
		
		Mockito.when(pService.findAll()).thenReturn(Arrays.asList(
				new Products(1, "breather", 500, 5, "www.breather.com", 1, 2),
				new Products(1, "Oxcigen", 1000, 10, "www.oxyigen", 1, 3)
				)
			);
		List<Products> pro = pService.findAll();
		Assert.assertEquals(pro.size(), 2, "list of products");
	
	}
	@Test
	public void testFindById() {
		Mockito.when(pService.findById("1")).thenReturn(
				Arrays.asList(new Products(1, "breather", 500, 5, "www.breather.com", 1, 2),
						new Products(2, "Oxcigen", 1000, 10, "www.oxyigen", 1, 3)));
		
		List<Products> pList = pService.findById("1");
		Assert.assertEquals(pList.get(0).getProduct_name(), "breather", "name match");
	}
	
	@Test
	public void testFindOneById() {
		Mockito.when(pService.findOneById(2)).thenReturn(new Products(1, "breather", 500, 5, "www.breather.com", 1, 2));
		
		Products pdt = pService.findOneById(2);
		Assert.assertEquals(pdt.getCategory_id(), 2, "category id");
	}
	
}
