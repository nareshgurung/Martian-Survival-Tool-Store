package net.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.revature.models.Purchase_group;
import net.revature.service.PurchaseGroupsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("purchaseGroupController")
@RequestMapping("/pGroup")
public class PurchaseGroupController {
// 	private UserService uService;
	private PurchaseGroupsService pgService;
	
	@Autowired
	public PurchaseGroupController(PurchaseGroupsService pgService) {
		super();
		this.pgService = pgService;
	}
	
	@GetMapping(path="/{userID}")
	public List<Purchase_group> getUsersGroups(@PathVariable int userID) {
		return this.pgService.getUsersGroups(userID);
	}

}
