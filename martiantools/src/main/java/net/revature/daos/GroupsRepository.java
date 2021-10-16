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

	public List<Groups> getByUserID(String userID) {
		List<Groups> list;
		list = this.entityManager.createQuery("From Groups where user_id=" + userID, Groups.class).getResultList();
		return list;
	}
	
	public Groups getWishlistFromUserID(String userID) {
		Groups group;
		System.out.println("userID:" + userID);
		group = this.entityManager.createQuery("From Groups where user_id=" + userID + " and group_name='Wishlist'", Groups.class).getSingleResult();
		return group;
	}

}