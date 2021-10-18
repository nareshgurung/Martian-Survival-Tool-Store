package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.revature.models.Purchased_items;

@Transactional
@Repository("piRepository")
public class PurchasedItemsRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Purchased_items> getItemsUsingGroupID(int groupID) {
		return this.entityManager.createQuery("FROM Purchased_items WHERE purchase_group_id=" + groupID, Purchased_items.class).getResultList();
	}
	
	public void addItemsToPurchasedTable(Purchased_items item) {
		this.entityManager.persist(item);
	}

}
