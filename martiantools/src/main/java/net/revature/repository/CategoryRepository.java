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
	
	public List<Categories> findAll(){
		return entityManager.createQuery("FROM Categories", Categories.class).getResultList();
	}
	
	public void save(Categories cat) {
		this.entityManager.persist(cat);
	}
	
	public Categories findByName(String id) {
		TypedQuery<Categories> query = 
				this.entityManager.createQuery("FROM Categories where category_id = :id", Categories.class);
		query.setParameter("name", id);
		return query.getSingleResult();
		
	}


}
