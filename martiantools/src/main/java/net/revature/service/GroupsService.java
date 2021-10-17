package net.revature.service;

import java.util.List;

import javax.transaction.Transactional;

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
	public Integer findUsersWishlist(int userID) {
		Groups wishlistID = groupsRepository.getWishlistFromUserID(userID);
		return wishlistID.getGroup_id();
	}

	public boolean addNewGroup(int userID, String groupName) {
		//TODO: check if the group exists already or not. Taken care of by the try/catch returning a boolean
		Groups newGroup = new Groups();
		newGroup.setGroup_name(groupName);
		newGroup.setUser_id(userID);
		return this.groupsRepository.addNewGroup(newGroup);

	}

	public boolean deleteGroup(int userID, int groupID) {
		Groups group = this.groupsRepository.getByGroupID(groupID);
		if(group.getGroup_name().equals("Wishlist"))
			return false;
		if(group.getUser_id()==userID)
			return this.groupsRepository.removeGroup(group);
		else
			return false;
	}

	@Transactional
	public boolean renameGroup(int userID, int groupID, String newName) {
		//TODO make sure that the user owns this group.
		Groups group = this.groupsRepository.getByGroupID(groupID);
		if(group.getGroup_name().equals("Wishlist"))
			return false;
		if(group.getUser_id()==userID) {
			group.setGroup_name(newName);
			return true;
		} else
		return false;
	}
}
