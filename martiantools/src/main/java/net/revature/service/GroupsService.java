package net.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.daos.GroupsRepository;
import net.revature.models.Groups;

@Service("gService")
public class GroupsService {
	private GroupsRepository groupsRepository;

	@Autowired
	public GroupsService(GroupsRepository groupsRepository) {
		this.groupsRepository = groupsRepository;
	}
	
	public List<Groups> findByUserID(String userID){
		return this.groupsRepository.getByUserID(userID);
	}
}
