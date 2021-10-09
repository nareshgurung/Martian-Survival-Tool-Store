package net.revature.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import net.revature.models.Categories;

@Repository("categoryRepository")
public class CategoryRepository {

	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Categories> getAll(){
		return entityManager.createQuery("FROM Categories", Categories.class).getResultList();
}
	
	public Categories getByCategoryID(String id) {
		TypedQuery<Categories> query = this.entityManager.createQuery("From Categories where category_id=:id", Categories.class);
		query.setParameter("id", id);
		return query.getSingleResult();
		
	}


}