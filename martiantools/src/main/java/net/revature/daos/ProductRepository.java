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
		return entityManager.createQuery("FROM Categories", Products.class).getResultList();
	}

}
