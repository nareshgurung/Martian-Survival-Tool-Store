package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import net.revature.models.Group_contents;

@Repository("groupContentsRepository")
public class GroupContentsRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Group_contents> getAll(){
		return entityManager.createQuery("FROM Group_contents", Group_contents.class).getResultList();
	}

}