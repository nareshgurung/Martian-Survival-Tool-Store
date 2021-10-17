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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.revature.models.Qa;
import net.revature.service.QAService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("qaController")
@RequestMapping("/qa")
public class QAController {
	private QAService qaService;
	@Autowired
	public QAController(QAService qaService) {
		super();
		this.qaService = qaService;
	}
	
	@GetMapping(path="getQuestions/{productID}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Qa>> getQuestionsForProduct(@PathVariable int productID) {
		return new ResponseEntity<List<Qa>>(this.qaService.getQuestionsForProduct(productID), HttpStatus.OK);
	}
	
	@PostMapping(path="newQuestion")
	public ResponseEntity<Boolean> newQuestion(@RequestBody Qa theQuestion){
		return new ResponseEntity<Boolean>(this.qaService.newQuestion(theQuestion), HttpStatus.OK);
	}
	
	@PostMapping(path="newAnswer")
	public ResponseEntity<Boolean> newAnswer(@RequestBody Qa theAnswer){
		final String WHITE_TEXT = "\u001B[37m";
		final String BLUE_BACKGROUND = "\u001B[44m";
		final String TEXT_COLOR_RESET = "\u001B[0m";
		final String BG_COLOR_RESET = "\u001B[47m"; 
		System.out.print(WHITE_TEXT + BLUE_BACKGROUND);
		System.out.println("Endpoint kicked. theQuestion.toString():" + theAnswer);
		System.out.print(TEXT_COLOR_RESET + BG_COLOR_RESET);
		return new ResponseEntity<Boolean>(this.qaService.newAnswer(theAnswer), HttpStatus.OK);
	}

}
