package net.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.daos.GroupContentsRepository;
import net.revature.daos.GroupsRepository;
import net.revature.models.Groups;

@Service("wService")
public class WishlistService {
	private GroupContentsRepository groupContentsRepository;
	private GroupsRepository groupsRepository;

	@Autowired
	public WishlistService(GroupContentsRepository groupContentsRepository, GroupsRepository groupsRepository) {
		super();
		this.groupContentsRepository = groupContentsRepository;
		this.groupsRepository = groupsRepository;
	}


	public Boolean addToWishlist(int productID, int userID, int amount) {
		Groups group = groupsRepository.getWishlistFromUserID(userID);
		groupContentsRepository.addProductToGroup(group.getGroup_id(), productID, amount);
		return null;
	}
	
	
}
