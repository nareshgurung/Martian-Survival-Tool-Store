import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import {catchError} from 'rxjs/operators';
import { GroupContents } from 'src/app/models/group_contents';

@Injectable({
  providedIn: 'root'
})
export class GroupContentsService {
	private url = 'http://52.14.63.20:8088/martiantools/group_contents/';

  constructor(private http: HttpClient, private router:Router) { }

///addToGroup/{groupID}/{productID}/{amount}")
  addItemToGroup(groupID:number,prodID:number): Observable<boolean>{
    return this.http.post<boolean>(`${this.url}addToGroup/${groupID}/${prodID}/1`, [])
    .pipe(
      catchError(this.handleError<boolean>('getCards')));
  }

  getGroupedItemsForUser(userID: number, groupID: number): Observable<GroupContents[]>{
    return this.http.get<GroupContents[]>(this.url + userID + "/" + groupID)
    .pipe(
      catchError(this.handleError<GroupContents[]>('getCards', [])));
  }

  removeItemFromGroup(groupID:number,productID:number):Observable<boolean> {
    console.log("attempting to remove " + productID + " from " + groupID)
    return this.http.post<boolean>(`${this.url}removeItem/${groupID}/${productID}`, [])
    .pipe(
      catchError(this.handleError<boolean>('getCards')));
  }

    /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
  private handleError<T>(operation = 'operation', result?: T) {
		return (error: any): Observable<T> => {

			console.error("CommentsService > ERROR: ", error);
      this.router.navigateByUrl('error');
			return of(result as T);
		};
	}
}
