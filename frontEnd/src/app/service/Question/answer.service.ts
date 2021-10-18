import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { QuestionsModel } from 'src/app/models/questions';

@Injectable({
  providedIn: 'root'
})
export class AnswerService {
	private url = 'http://52.14.63.20:8088/martiantools/qa/';

	constructor(private http: HttpClient, private router:Router) { }

  public getQuestionsForProduct(productID:number):Observable<QuestionsModel[]> {
    return this.http.get<QuestionsModel[]>(this.url + "getQuestions/" + productID)
		.pipe(
			catchError(this.handleError<QuestionsModel[]>('getAllComments'))
		);
  }

  public setNewQuestion(model:QuestionsModel): Observable<boolean>{
    return this.http.post<boolean>(this.url + "newQuestion", model)
		.pipe(
			catchError(this.handleError<boolean>('getAllComments'))
		);
  }

  public setNewAnswer(model:QuestionsModel): Observable<boolean>{
    return this.http.post<boolean>(this.url + "newAnswer", model)
		.pipe(
			catchError(this.handleError<boolean>('getAllComments'))
		);
  }


  private handleError<T>(operation = 'operation', result?: T) {
		return (error: any): Observable<T> => {

			console.error("CommentsService > ERROR: ", error);

			this.router.navigateByUrl('error');
			return of(result as T);
		};
	}

}
