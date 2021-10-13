import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import { GenericCard } from 'src/app/models/card';
import { Groups } from 'src/app/models/groups';

@Injectable({
  providedIn: 'root'
})
export class GroupContentsService {
	private url = 'http://localhost:8080/SpringCore/group_contents/';


  constructor(private http: HttpClient) { }


  getGroupedItemsForUser(userID: number, groupID: number): Observable<GenericCard[]>{
    return this.http.get<GenericCard[]>(this.url + userID + "/" + groupID)
    .pipe(
      catchError(this.handleError<GenericCard[]>('getCards', [])));
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

			return of(result as T);
		};
	}
}
