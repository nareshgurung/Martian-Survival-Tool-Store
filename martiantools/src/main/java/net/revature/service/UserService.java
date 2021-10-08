package net.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.getAll.FromUsers;
import net.revature.models.Users;

@Service("uService")
public class UserService {

	private FromUsers usersRepository;
	
	@Autowired
	public UserService(FromUsers usersRepository) {

		this.usersRepository=usersRepository;
		System.out.println("service works");
	}
	
	public List<Users> getAllUsers(){
		return this.usersRepository.getAll();
	}
	
	public Users getByUsername(String username) {
		return this.usersRepository.getByUsername(username);
	}
}
