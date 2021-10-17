package net.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.revature.models.Comments;
import net.revature.service.CommentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("commentsController")
@RequestMapping("/comments")
@EnableTransactionManagement
public class CommentsController {

	private CommentService commentService;

	@Autowired
	public CommentsController(CommentService service){
		this.commentService = service;
	}

	@GetMapping(path="/{productID}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comments>> getAllForProduct(@PathVariable int productID){
		return new ResponseEntity<List<Comments>>(this.commentService.getAllForProduct(productID), HttpStatus.OK);
	}

	// @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
	// getCommentByUserID

	// @PostMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
	// postComment
	
	@PostMapping(path="/newComment", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> saveComment(@RequestBody Comments comment) {
		final String WHITE_TEXT = "\u001B[37m";
		final String BLUE_BACKGROUND = "\u001B[44m";
		final String TEXT_COLOR_RESET = "\u001B[0m";
		final String BG_COLOR_RESET = "\u001B[47m"; 
		System.out.println(WHITE_TEXT + BLUE_BACKGROUND);
		System.out.println("Endpoint kicked. comment.toString():" + comment.toString());
		System.out.println(TEXT_COLOR_RESET + BG_COLOR_RESET);
		
		return new ResponseEntity<Boolean>(this.commentService.saveComment(comment), HttpStatus.OK);
	}
}
