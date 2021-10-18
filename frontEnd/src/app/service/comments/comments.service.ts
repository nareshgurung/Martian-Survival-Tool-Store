import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Comment } from '../../models/comment';
import {catchError} from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
	providedIn: 'root'
})
export class CommentsService {
	private url = 'http://52.14.63.20:8088/martiantools/comments/';

	constructor(private http: HttpClient, private router:Router) { }

	getCommentsForProduct(productID:number): Observable<Comment[]> {
		return this.http.get<Comment[]>(this.url + productID)
		.pipe(
			catchError(this.handleError<Comment[]>('getAllComments', []))
		);
	}

	setNewComment(comment:Comment): Observable<boolean>{
		console.log("comment:" + comment.comment)
		return this.http.post<boolean>(this.url+"/newComment", comment)
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