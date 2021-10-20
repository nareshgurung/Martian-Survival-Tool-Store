package net.revature.junitTest;

import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;

import net.revature.daos.GroupsRepository;
import net.revature.models.Groups;
import net.revature.models.Users;
import net.revature.service.GroupsService;

public class GroupServiceTest {
	
	@InjectMocks
	private static GroupsService gServ;
	
	@Mock
	private GroupsRepository gRepo; 
	
	{
		MockitoAnnotations.openMocks(this);
	}

	public static void setUp() {
		gServ = new GroupsService();
	}
	
	@Test
	public void testFindByUserID() {
		Mockito.when(gServ.findByUserID("1")).thenReturn(Arrays.asList(
				new Groups(1, "group", 1),
				new Groups(2, "group1", 1)));
		List<Groups> lGrp = gServ.findByUserID("1");
		Assert.assertEquals(lGrp.size(), 2, "total groups by user");
	}
	
	@Test
	public void testAddNewGroup() {
		
		Users usr = new Users(1, 1, "", "", "", "", "", 12457, "", "", "", "");
		Mockito.when(gServ.addNewGroup(usr.getUser_id(), "wishlist")).thenReturn(true);
		boolean gp = gServ.addNewGroup(1, "wishlist");
		Assert.assertTrue(gp);
		
	}
	
	@Test
	public void testDeleteGroup() throws Exception {
		Groups grp = new Groups(1, "group", 1);
		
		boolean rm = gRepo.removeGroup(grp);
		
		Assert.assertFalse(rm);
//		Mockito.when(gServ.deleteGroup(1, 1)).thenReturn(null);	
//		Mockito.verify(gRepo).removeGroup(grp);
		
	}
	
	@Test
	public void testRenameGroup() {
		
		Groups grp = new Groups(1, "Wishlist", 1);
		
		
		grp.setGroup_name("deeplist");
		
//		boolean newd = gServ.renameGroup(1, 1, "deeplist");
		
//		Mockito.when(gRepo.getByGroupID(1)).thenReturn(new Groups(1, "wishlist", 1));
//		Mockito.when(gServ.renameGroup(1, 1, "deeplist")).thenReturn(true);
//		
//		Assert.assertTrue(true);
		
		Assert.assertEquals(grp.getGroup_name(), "deeplist");
	}
}






