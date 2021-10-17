package net.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.daos.QARepository;
import net.revature.models.Qa;

@Service("qaService")
public class QAService {
	private QARepository qaRepo;
	@Autowired
	public QAService(QARepository qaRepo) {
		super();
		this.qaRepo = qaRepo;
	}

	public List<Qa> getQuestionsForProduct(int productID) {
		return this.qaRepo.getQuestionsForProduct(productID);
	}

	public Boolean newQuestion(Qa theQuestion) {
		//TODO pass the correct userID from the frontend or dont show the button 
		if(theQuestion.getUser_id()<1)
			theQuestion.setUser_id(13);
		return this.qaRepo.save(theQuestion);
	}

	@Transactional
	public Boolean newAnswer(Qa theAnswer) {
		//TODO pass the correct userID from the frontend or dont show the button 
		if(theAnswer.getUser_id()<1)
			theAnswer.setUser_id(13);
		Qa tempQuestion = this.qaRepo.getQuestionByQuestionID(theAnswer.getQa_id());
		tempQuestion.setQa_answer(theAnswer.getQa_answer());
		return this.qaRepo.save(tempQuestion);
	}
}
