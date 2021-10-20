package net.revature.junitTest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;

import net.revature.daos.PurchaseGroupsRepository;
import net.revature.models.Purchase_group;
import net.revature.service.PurchaseGroupsService;

public class PurchasedGroupsServiceTest {
	
	@InjectMocks
	private static PurchaseGroupsService pgServ;
	
	@Mock
	private PurchaseGroupsRepository pgRepo;
	
	{
		MockitoAnnotations.openMocks(this);

	}
	
	@BeforeClass
	public static void setUp() {
		pgServ = new PurchaseGroupsService();
	}
	
	@Test
	public void testgetUsersGroup() {
		
		Mockito.when(pgServ.getUsersGroups(1)).thenReturn(Arrays.asList(
						new Purchase_group(1, 1, Timestamp.valueOf("2018-09-01 09:01:15")),
						new Purchase_group(2, 1, Timestamp.valueOf("2018-09-01 09:02:15"))
								)
						);
		List<Purchase_group> purGroup = pgServ.getUsersGroups(1);
		Assert.assertEquals(purGroup.size(), 2, "totoal purchase Group");
	}

}
