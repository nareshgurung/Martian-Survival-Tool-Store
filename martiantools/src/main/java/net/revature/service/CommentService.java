package net.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.daos.CommentsRepository;
import net.revature.models.Comments;

@Service("commentService")
public class CommentService {

	private CommentsRepository commentRepository;

	@Autowired
	public CommentService(CommentsRepository repository) {
		this.commentRepository = repository;
	}

	public List<Comments> getAllForProduct(int productID){
		return this.commentRepository.getAllForProduct(productID);
	}
	public boolean saveComment(Comments obj) {
		obj.setComment_id(0);
		return this.commentRepository.saveComment(obj);
	}
	
}
