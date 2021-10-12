package net.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.revature.models.Group_contents;
import net.revature.service.Group_contentsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("group_contentsController")
@RequestMapping("/group_contents")
public class Group_contentsController {
	private Group_contentsService gcService;

	@Autowired
	public Group_contentsController(Group_contentsService gcService) {
		this.gcService = gcService;
	}
	
	@GetMapping(path="/{userID}/{groupID}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Group_contents>> getAll(@PathVariable String userID, @PathVariable String groupID){
		return new ResponseEntity<List<Group_contents>>(this.gcService.findUserGroupByUserIDAndGroupID(groupID, userID), HttpStatus.OK);
	}

	
}
