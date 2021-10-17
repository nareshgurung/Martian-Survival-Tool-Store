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
		return this.entityManager.createQuery("FROM Purchased_items WHERE purchases_group_id=" + groupID, Purchased_items.class).getResultList();
	}

}
