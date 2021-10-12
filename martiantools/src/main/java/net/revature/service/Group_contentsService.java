package net.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.daos.GroupContentsRepository;
import net.revature.models.Group_contents;

@Service("gcService")
public class Group_contentsService {
	private GroupContentsRepository groupContentsRepository;

	@Autowired
	public Group_contentsService(GroupContentsRepository groupContentsRepository) {
		super();
		this.groupContentsRepository = groupContentsRepository;
	}
	
	public List<Group_contents> findUserGroupByUserIDAndGroupID(String groupID, String userID) {
		System.out.println("groupID: " + groupID);
		System.out.println("userID: " + userID);
		//TODO: add in user checking so that you cant just change your groupID in the URL and see/edit someone elses groups
		return this.groupContentsRepository.getByGroupID(groupID);
	}
}
