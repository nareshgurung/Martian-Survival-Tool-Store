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

	public List<Groups> getByUserID(String userID) {
		List<Groups> list;
		list = this.entityManager.createQuery("From Groups where user_id=" + userID, Groups.class).getResultList();
		return list;
	}

}