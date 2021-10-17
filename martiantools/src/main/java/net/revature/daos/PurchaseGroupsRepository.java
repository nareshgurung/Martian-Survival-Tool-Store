package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.revature.models.Purchase_group;

@Transactional
@Repository("pgRepository")
public class PurchaseGroupsRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Purchase_group> getUsersGroups(int userID) {
		return entityManager.createQuery("FROM Purchase_group WHERE user_id=" + userID, Purchase_group.class).getResultList();
	}

}
