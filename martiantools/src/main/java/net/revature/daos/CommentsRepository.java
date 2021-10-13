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

	public List<Comments> getAll() {
		return entityManager.createQuery("FROM Comments", Comments.class).getResultList();
	}
	
	public void saveComment(Comments obj) {
		this.entityManager.persist(obj);
	}
}
