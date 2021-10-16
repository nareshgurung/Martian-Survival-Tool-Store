package net.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.revature.models.Users;
import net.revature.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("usersController")
@RequestMapping("/users")
@EnableTransactionManagement 
public class userController {

	private UserService uService;

	@Autowired
	public userController(UserService usersService){
		this.uService=usersService;
	}

	@PostMapping(path="/login/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Users login(@PathVariable String username, @PathVariable String password) {
		return this.uService.getUserWithUsernameAndPassword(username, password);
	}
	@PostMapping(path="/signup", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void saveUsers(@RequestBody Users user) {
		this.uService.save(user);
	}
}
