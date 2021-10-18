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

import net.revature.daos.PurchasedItemsRepository;
import net.revature.models.Purchased_items;
import net.revature.service.PurchasedItemsService;

public class PurchaseItemTest {
	
	@InjectMocks
	private static PurchasedItemsService purServ;
	
	@Mock
	private PurchasedItemsRepository pRepo;
	
	{
		MockitoAnnotations.openMocks(this);
	}

	@BeforeClass
	public static void setUp() {
		
		purServ = new PurchasedItemsService();
	}
	
	@Test
	public void testGetItemUsingGroupId() {
		
		Mockito.when(purServ.getItemsUsingGroupID(1)).thenReturn(
				Arrays.asList(new Purchased_items(1, 1, 1, 500), 
								new Purchased_items(2, 1, 3, 700)));
		
		List<Purchased_items> lPurchased = purServ.getItemsUsingGroupID(1);
		Assert.assertEquals(lPurchased.get(0).getAmount(), 500);
	}
}
