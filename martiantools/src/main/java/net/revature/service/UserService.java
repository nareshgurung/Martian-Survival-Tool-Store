package net.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.daos.GroupsRepository;
import net.revature.daos.UsersRepository;
import net.revature.models.Groups;
import net.revature.models.Users;

@Transactional

@Service("uService")
public class UserService {

	private UsersRepository usersRepository; 
	private GroupsRepository groupRepository;
	
	@Autowired
	public UserService(UsersRepository usersRepository, GroupsRepository groupRepository) {

		this.usersRepository=usersRepository;
		this.groupRepository=groupRepository;
	}
	
	public List<Users> getAllUsers(){
		return this.usersRepository.getAll();
	}
	
	public Users getByUsername(String username) {
		Users usr = this.usersRepository.getByUserName(username);
		usr.setUser_username("");
		usr.setUser_password("");
		return usr;
	}
	public void save(Users obj) {
		System.out.println(obj);
	this.usersRepository.save(obj);
	Users usr = usersRepository.getByUserName(obj.getUser_username());
	Groups gp = new Groups("Wishlist", usr.getUser_id());
	this.groupRepository.saveGroup(gp);
	}
}
