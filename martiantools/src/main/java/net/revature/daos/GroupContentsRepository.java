package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.revature.models.Group_contents;

@Transactional
@Repository("groupContentsRepository")
public class GroupContentsRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Group_contents> getAll(){
		return entityManager.createQuery("FROM Group_contents", Group_contents.class).getResultList();
	}
	
	public List<Object[]> getByGroupID(String groupID) {
		List<Object[]> list;
		list = this.entityManager.createQuery("SELECT p.product_name, p.product_id,gc.group_contents_amount FROM Group_contents as gc , Products as p WHERE gc.product_id=p.product_id AND group_id=" + groupID, Object[].class).getResultList();
		return list;
	}

	public void addProductToGroup(Group_contents groupContents) {
		this.entityManager.persist(groupContents);
	}
	
	public boolean removeProductFromGroup(int groupID, int productID) {
	try {
		Group_contents gc = this.entityManager.createQuery("FROM Group_contents WHERE group_id=" + groupID + " AND product_id=" + productID, Group_contents.class).getSingleResult();
		this.entityManager.remove(gc);
	} catch (IllegalArgumentException e) {
		e.printStackTrace();
		return false;
	}
	return true;
		
	}
}