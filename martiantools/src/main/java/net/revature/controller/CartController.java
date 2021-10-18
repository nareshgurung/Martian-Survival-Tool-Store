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
		final String WHITE_TEXT = "\u001B[37m";
		final String BLUE_BACKGROUND = "\u001B[44m";
		final String TEXT_COLOR_RESET = "\u001B[0m";
		final String BG_COLOR_RESET = "\u001B[47m"; 
		System.out.print(WHITE_TEXT + BLUE_BACKGROUND);
		System.out.println("Endpoint kicked. obj.frm.name:" + sillyObj.getFrm().getName());
		System.out.print(TEXT_COLOR_RESET + BG_COLOR_RESET);
		return new ResponseEntity<Boolean>(this.cService.addToWeirdosCart(sillyObj), HttpStatus.OK);
	}

}
