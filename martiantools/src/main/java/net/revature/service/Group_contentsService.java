package net.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.daos.GroupContentsRepository;
import net.revature.models.GroupContentsAsProducts;

@Service("gcService")
public class Group_contentsService {
	private GroupContentsRepository groupContentsRepository;
	
	@Autowired
	public Group_contentsService(GroupContentsRepository groupContentsRepository) {
		super();
		this.groupContentsRepository = groupContentsRepository;
	}

	public List<GroupContentsAsProducts> findUserGroupByUserIDAndGroupID(String groupID, String userID) {
		//TODO: add in user checking so that you cant just change your groupID in the URL and see/edit someone elses groups
		
		List<Object[]> list = this.groupContentsRepository.getByGroupID(groupID);
		ArrayList<GroupContentsAsProducts> gcaps = new ArrayList<GroupContentsAsProducts>();
		for(Object[] objarr : list) {
			GroupContentsAsProducts gcap = new GroupContentsAsProducts(
					((String)objarr[0]), 
					(int)objarr[1]);
			gcaps.add(gcap);
		}
		return gcaps;
	}
}
