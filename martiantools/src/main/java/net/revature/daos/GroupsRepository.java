package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import net.revature.models.Groups;

@Repository("groupsRepository")
public class GroupsRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Groups> getAll(){
		return entityManager.createQuery("FROM Groups", Groups.class).getResultList();
	}

}