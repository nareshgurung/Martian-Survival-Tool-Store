package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import net.revature.models.Users;

@Repository("usersRepository")
public class UsersRepository {
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Users> getAll(){
			return entityManager.createQuery("FROM Users", Users.class).getResultList();
	}
	
	public Users getByUserID(String id) {
		TypedQuery<Users> query = this.entityManager.createQuery("From Users where user_id=:id", Users.class);
		query.setParameter("username", id);
		return query.getSingleResult();
		
	}

	
}
