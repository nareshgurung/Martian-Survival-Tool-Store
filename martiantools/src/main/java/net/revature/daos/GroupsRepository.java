package net.revature.daos;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

	public Groups getWishlistFromUserID(int userID) {
		Groups group;
		group = this.entityManager.createQuery("From Groups where user_id=" + userID + " and group_name='Wishlist'", Groups.class).getSingleResult();
		return group;
	}

	public boolean addNewGroup(Groups newGroup) {
		try {
			this.entityManager.persist(newGroup);
		} catch (EntityExistsException e) {
			return false;
		};
		return true;
	}

	public boolean removeGroup(Groups group) {
		try {
			group = this.entityManager.find(Groups.class, group.getGroup_id());
			this.entityManager.remove(group);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Groups getByGroupID(int groupID) {
		Groups group;
		group = this.entityManager.createQuery("From Groups where group_id=" + groupID, Groups.class).getSingleResult();
		return group;
	}

}