package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import net.revature.models.Products;

@Repository("productRepository")
public class ProductRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Products> getAll(){
		return entityManager.createQuery("FROM Products", Products.class).getResultList();
	}

	public List<Products> getByCategoryID(String id) {
		List<Products> list;
		list = this.entityManager.createQuery("From Products where category_id=" + id, Products.class).getResultList();
		return list;
	}

}
