package net.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
		System.out.println("controller constructor");
		this.uService=usersService;
	}

	@GetMapping(path="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> getAll(){
		System.out.println("controller works");
		return new ResponseEntity<List<Users>>(this.uService.getAllUsers(), HttpStatus.OK);
	}

	@PostMapping(path="/login/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void login(@PathVariable String username, @PathVariable String password) {

		Users unameFromClient = this.uService.getByUsername(username);
			String unameFromDB = unameFromClient.getUser_username();
			String passwordFromDB = unameFromClient.getUser_password();
			
			if((unameFromDB.equals(username)) && (passwordFromDB.equals(password))) {
				System.out.println("your are logged in");
				
				
			}else {
				System.out.println("Bad credentials");
			}
			
//			return unameFromClient;
		String unameFromDB = unameFromClient.getUser_username();
		String passwordFromDB = unameFromClient.getUser_password();

		if((unameFromDB.equals(username)) && (passwordFromDB.equals(password))) {
			System.out.println("your are logged in");

		}else {
			System.out.println("Bad credentials");
		}

		//			return unameFromClient;
	}
	@PostMapping(path="/signup", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void saveUsers(@RequestBody Users user) {
		System.out.println(user);
		this.uService.save(user);
	}
}
