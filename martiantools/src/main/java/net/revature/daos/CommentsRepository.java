package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import net.revature.models.Comments;

@Repository("commentsRepository")
public class CommentsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Comments> getAll() {
		return entityManager.createQuery("FROM Comments", Comments.class).getResultList();
	}
}
