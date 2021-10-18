package net.revature.junitTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;

import net.revature.daos.CommentsRepository;
import net.revature.models.Comments;
import net.revature.service.CommentService;

public class commentServiceTest {

	@InjectMocks
	private static CommentService cmtServ;
	
	@Mock
	private CommentsRepository cmtRepo;
	
	@Mock
	Comments newCmt = new Comments(1, 2, 1, "superb");
	{
		MockitoAnnotations.openMocks(this);
	}
	
	public static void setUp() {
		cmtServ = new CommentService();
	}
	
	@Test
	public void testCommentFindAll() {
		Mockito.when(cmtServ.findAll()).thenReturn(Arrays.asList(
				new Comments(1, 1, 1, "comment"), 
				new Comments(2, 1, 1, "commment2")
				));
	
	List<Comments> cmtList = cmtServ.findAll();
	Assert.assertEquals(cmtList.size(), 2, "list comments");
	}
	
	@Test
	public void testSaveComment() {
		cmtRepo.saveComment(newCmt);
		verify(cmtRepo, times(1)).saveComment(newCmt);
	}
}
