package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.revature.models.Groups;


@Transactional
@Repository("groupsRepository")
public class GroupsRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Groups> getAll(){
		return entityManager.createQuery("FROM Groups", Groups.class).getResultList();
	}
	
	public void saveGroup(Groups obj) {
		this.entityManager.persist(obj);
	}

}