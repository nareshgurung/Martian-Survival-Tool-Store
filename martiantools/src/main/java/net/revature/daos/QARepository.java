package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.revature.models.Qa;


@Transactional
@Repository("qaRepository")
public class QARepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Qa> getAll(){
		return entityManager.createQuery("FROM Qa", Qa.class).getResultList();
	}

	public List<Qa> getQuestionsForProduct(int productID) {
		return this.entityManager.createQuery("FROM Qa WHERE product_id=" + productID, Qa.class).getResultList();
	}

	public Boolean save(Qa theQuestion) {
		this.entityManager.persist(theQuestion);
		return true;
	}

	public Qa getQuestionByQuestionID(int qa_id) {
		return this.entityManager.createQuery("FROM Qa WHERE qa_id=" + qa_id, Qa.class).getSingleResult();	
	}

}