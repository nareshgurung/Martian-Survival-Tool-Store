import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { QuestionsModel } from 'src/app/models/questions';
import { AnswerService } from 'src/app/service/Question/answer.service';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit,OnChanges {
  @Input() productID:number = -1;
  questions:QuestionsModel[] = [];
  newQuestion:string = "";
  newAnswer:string = "";

  constructor(private router:Router, private aRout:ActivatedRoute, private getAnswers:AnswerService) { }

  ngOnInit(): void {
  }
	ngOnChanges(change: SimpleChanges): void{
    this.fillQuestions();
	}


  fillQuestions(){
    this.getAnswers.getQuestionsForProduct(this.productID).subscribe(subs=> this.questions = subs);
  }

  submitQuestion(){
    let theQuestion:QuestionsModel = {
      qa_id:0,qa_question:this.newQuestion,qa_answer:"",product_id:this.productID,user_id:NavbarComponent.userInfo.user_id
    };
    this.getAnswers.setNewQuestion(theQuestion).subscribe();
    let currentURL = this.router.url;
		this.router.navigateByUrl('/error').then(
			() => this.router.navigateByUrl(currentURL)
		);

  }

  submitAnswer(aQuestion:string, questionID:number){
    let theQuestion:QuestionsModel = {
      qa_id:questionID,qa_question:aQuestion,qa_answer:this.newAnswer,product_id:this.productID,user_id:NavbarComponent.userInfo.user_id
    };
    this.getAnswers.setNewAnswer(theQuestion).subscribe();
    let currentURL = this.router.url;
		this.router.navigateByUrl('/error').then(
			() => this.router.navigateByUrl(currentURL)
		);
  }
}
