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
	
	public List<Object[]> getByGroupID(String groupID) {
		List<Object[]> list;
		list = this.entityManager.createQuery("SELECT p.product_name,gc.group_contents_amount FROM Group_contents as gc , Products as p WHERE gc.product_id=p.product_id", Object[].class).getResultList();
		return list;
	}
}