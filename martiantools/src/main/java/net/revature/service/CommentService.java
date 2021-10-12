package net.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.models.Comments;
import net.revature.daos.CommentsRepository;

@Service("commentService")
public class CommentService {

	private CommentsRepository commentRepository;

	@Autowired
	public CommentService(CommentsRepository repository) {
		this.commentRepository = repository;
	}

	public List<Comments> findAll(){
		return this.commentRepository.getAll();
	}
}
