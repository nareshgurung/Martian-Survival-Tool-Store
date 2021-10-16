package net.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.revature.service.WishlistService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("wishlistController")
@RequestMapping("/wishlist")
public class WishlistController {
	private WishlistService wService;
	
	@Autowired
	public WishlistController(WishlistService wishlistService) {
		super();
		this.wService = wishlistService;
	}

	@PostMapping(path="/{productID}/{amount}/{userID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addItemsToWishList(@PathVariable int productID, @PathVariable int userID, @PathVariable int amount){
		return new ResponseEntity<Boolean>(this.wService.addToWishlist(productID, userID, amount), HttpStatus.OK);
	}

}
