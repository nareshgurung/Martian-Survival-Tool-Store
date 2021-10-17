package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.revature.models.Comments;


@Transactional
@Repository("commentsRepository")
public class CommentsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Comments> getAllForProduct(int productID) {
		List<Comments> comments = entityManager.createQuery("FROM Comments WHERE product_id=" + productID, Comments.class).getResultList();
		return comments; 
	}
	
	public boolean saveComment(Comments obj) {
		this.entityManager.persist(obj);
		return true;
	}
}
