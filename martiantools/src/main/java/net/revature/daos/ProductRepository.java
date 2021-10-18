package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.revature.models.Products;

@Transactional
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

	public Products getByProductID(int productID) {
		Products list;
		list = this.entityManager.createQuery("From Products where product_id=" + productID, Products.class).getSingleResult();
		return list;
	}

	public void removeItemAmountFromItem(Products p, int amount) {
		Products temp = this.entityManager.createQuery("From Products where product_id=" + p.getProduct_id(), Products.class).getSingleResult();
		int finalNumber = p.getProduct_quantity()-amount;
		temp.setProduct_quantity(finalNumber);
	}
}
