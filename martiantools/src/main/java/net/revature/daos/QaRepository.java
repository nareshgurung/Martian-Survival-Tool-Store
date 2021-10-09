package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import net.revature.models.Qa;

@Repository("groupContentsRepository")
public class QaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Qa> getAll(){
		return entityManager.createQuery("FROM Qa", Qa.class).getResultList();
	}

}