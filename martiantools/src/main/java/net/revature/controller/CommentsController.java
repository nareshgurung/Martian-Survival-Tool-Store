package net.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping(path="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comments>> getAll(){
		return new ResponseEntity<List<Comments>>(this.commentService.findAll(), HttpStatus.OK);
	}

	// @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
	// getCommentByUserID

	// @PostMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
	// postComment
	
	@PostMapping(path="/usercomment")
	public void saveComment(@RequestBody Comments comment) {
		this.commentService.saveComment(comment);
	}
}
