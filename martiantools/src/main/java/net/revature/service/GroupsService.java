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
		//TODO make sure that the user owns this group. AND that its not a wishlist
		Groups group = this.groupsRepository.getByGroupID(groupID);
		return this.groupsRepository.removeGroup(group);
	}
}
