package net.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.revature.models.SillyModelsAreSillyButTheyWork;
import net.revature.service.CartService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("cartController")
@RequestMapping("/cart")
public class CartController {
	private CartService cService;

	@Autowired
	public CartController(CartService cService) {
		super();
		this.cService = cService;
	}

	// 
	@PostMapping(path="/add")
	public ResponseEntity<Boolean> getAll(@RequestBody SillyModelsAreSillyButTheyWork sillyObj){
		return new ResponseEntity<Boolean>(this.cService.addToWeirdosCart(sillyObj), HttpStatus.OK);
	}

}
