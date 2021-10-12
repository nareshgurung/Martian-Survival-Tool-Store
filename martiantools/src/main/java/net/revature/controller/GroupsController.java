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

import net.revature.models.Groups;
import net.revature.service.GroupsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("groupsController")
@RequestMapping("/groups")
public class GroupsController {
	private GroupsService gService;

	@Autowired
	public GroupsController(GroupsService gService) {
		this.gService = gService;
	}
	
	@GetMapping(path="/{userID}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Groups>> getAll(@PathVariable String userID){
		return new ResponseEntity<List<Groups>>(this.gService.findByUserID(userID), HttpStatus.OK);
	}
}
