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
	
	public Users getUserWithUsernameAndPassword(String username, String password) {
		Users usr = this.usersRepository.getByUserName(username);
		
		if((usr.getUser_username().equals(username)) && (usr.getUser_password().equals(password))) {
			return usr;
		}else {
			return null;
		}
	}
	public void save(Users obj) {
		System.out.println(obj);
	this.usersRepository.save(obj);
	Users usr = usersRepository.getByUserName(obj.getUser_username());
	Groups gp = new Groups("Wishlist", usr.getUser_id());
	this.groupRepository.saveGroup(gp);
	}

	@Transactional
	public boolean updateUserInfo(Users user) {
		//TODO this is dumb, there should be a better way. I just couldnt find it and stopped looking after a while
		Users oldInfo = usersRepository.getByUserID(user.getUser_id());
		oldInfo.setUser_city(user.getUser_city());
		oldInfo.setUser_email(user.getUser_email());
		oldInfo.setUser_fname(user.getUser_fname());
		oldInfo.setUser_lname(user.getUser_lname());
		oldInfo.setUser_midinnitial(user.getUser_midinnitial());
		oldInfo.setUser_password(user.getUser_password());
		oldInfo.setUser_state(user.getUser_state());
		oldInfo.setUser_street(user.getUser_street());
		oldInfo.setUser_username(user.getUser_username());
		oldInfo.setUser_zip(user.getUser_zip());
		return true;
	}
}
