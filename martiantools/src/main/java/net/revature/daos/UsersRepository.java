package net.revature.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.revature.models.Users;

@Transactional
@Repository("usersRepository")
public class UsersRepository {
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Users> getAll(){
			return entityManager.createQuery("FROM Users", Users.class).getResultList();
	}
	
	public Users getByUserName(String username) {
		TypedQuery<Users> query = this.entityManager.createQuery("From Users where user_username=:username", Users.class);
		query.setParameter("username", username);
		return query.getSingleResult();
		
	}
	public void save(Users obj) {
		
		this.entityManager.persist(obj);
	}
	
	
}
