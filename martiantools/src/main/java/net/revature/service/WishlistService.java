package net.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.daos.GroupContentsRepository;
import net.revature.daos.GroupsRepository;
import net.revature.models.Group_contents;
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
		Groups wishlistGroup = groupsRepository.getWishlistFromUserID(userID);
		Group_contents groupContents = new Group_contents();
		groupContents.setGroup_id(wishlistGroup.getGroup_id());
		groupContents.setProduct_id(productID);
		groupContents.setGroup_contents_amount(amount);
		this.groupContentsRepository.addProductToGroup(groupContents);
		return null;
	}
	
	
}
