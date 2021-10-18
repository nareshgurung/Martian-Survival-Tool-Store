package net.revature.junitTest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;

import net.revature.daos.GroupsRepository;
import net.revature.daos.UsersRepository;
import net.revature.models.Groups;
import net.revature.models.Users;
import net.revature.service.UserService;

public class UserServiceTest {

	@InjectMocks
	private static UserService uService;
	
	@Mock 
	private UsersRepository uRepo;
	private GroupsRepository gRepo;
//	Users  u = new Users(1, 1, "Nima@gmail", "naresh", "", "", "st", 1452, "", "", "dplmn", "password");
	Users usr = new Users(1, 1, "Nima@gmail", "naresh", "", "", "st", 1452, "", "", "paktt", "Powerful");
	
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeClass
	public static void setUp() {
		UserService uService = new UserService();
		Groups gp = new Groups();
		
	}
	
	@Test 
	public void testGetall() {
		
		Mockito.when(uService.getAllUsers()).thenReturn(
				Arrays.asList(
						new Users(1, 1, "Nima@gmail", "naresh", "", "", "st", 1452, "", "", "", ""),
						new Users(2, 1, "Alex@gmail", "alex", "", "", "street", 2451, "", "", "", "")
						)
				);
		List<Users> usr = uService.getAllUsers();
		
		Assert.assertEquals(usr.size(), 2, "list users");
	}
	@Test 
	public void testLogin() {
		
		
		when(uRepo.getByUserName(anyString())).thenReturn(usr);

		Users loggedIn = uService.getUserWithUsernameAndPassword("paktt", "Powerful");

		Assert.assertEquals(usr.getUser_id(), loggedIn.getUser_id());
	}
	
	@Test
	public void saveTest() {
		uRepo.save(usr);
		verify(uRepo, times(1)).save(usr);
	}
	
	
}
