//package net.revature.junitTest;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.testng.Assert;
//
//import net.revature.daos.UsersRepository;
//import net.revature.models.Users;
//import net.revature.service.UserService;
//
//public class UserServiceTest {
//
//	@InjectMocks
//	private static UserService uService;
//	
//	@Mock 
//	private UsersRepository uRepo;
//	
//	{
//		MockitoAnnotations.openMocks(this);
//	}
//	
//	@BeforeClass
//	public static void setUp() {
//		UserService uService = new UserService();
//		
//	}
//	
//	@Test 
//	public void testGetall() {
//		
//		Mockito.when(uService.getAllUsers()).thenReturn(
//				Arrays.asList(
//						new Users(1, 1, "Nima@gmail", "naresh", "", "", "st", 1452, "", "", "", ""),
//						new Users(2, 1, "Alex@gmail", "alex", "", "", "street", 2451, "", "", "", "")
//						)
//				);
//		List<Users> usr = uService.getAllUsers();
//		
//		Assert.assertEquals(usr.size(), 2, "list users");
//	}
//	
//}
