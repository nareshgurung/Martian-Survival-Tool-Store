package net.revature.getAll;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import net.revature.models.Users;

@Repository("usersRepository")

public class FromUsers {
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Users> getAll(){
		
			return entityManager.createQuery("FROM Users", Users.class).getResultList();
	}
	
	public Users getByUsername(String username) {
		
		TypedQuery<Users> query = this.entityManager.createQuery("From Users where user_username=:username", Users.class);
		query.setParameter("username", username);
		return query.getSingleResult();
		
	}

	
}
