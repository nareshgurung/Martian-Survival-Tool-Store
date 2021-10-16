package net.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping(path="/wishlist/{userID}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> getWishlistID(@PathVariable int userID){
		if(userID<0) {
			System.out.println("GroupsRepository_getWishlistFromUserID: it was less than 0");
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Integer>(this.gService.findUsersWishlist(userID), HttpStatus.OK);
	}

	@PostMapping(path="/addNewGroup/{userID}/{groupName}")
	public ResponseEntity<Boolean> addNewGroup(@PathVariable int userID, @PathVariable String groupName) {
		if(this.gService.addNewGroup(userID, groupName))
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
	}

	@PostMapping(path="/deletegroup/{userID}/{groupID}")
	public ResponseEntity<Boolean> deleteGroup(@PathVariable int userID, @PathVariable int groupID) {
		if(this.gService.deleteGroup(userID, groupID))
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
	}
	
	@PostMapping(path="/renameGroup/{userID}/{groupID}/{newName}")
	public ResponseEntity<Boolean> renameGroup(@PathVariable int userID, @PathVariable int groupID, @PathVariable String newName){
	if(this.gService.renameGroup(userID, groupID, newName))
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	else
		return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
	}

}
