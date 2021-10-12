import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import { Groups } from 'src/app/models/groups';

@Injectable({
  providedIn: 'root'
})
export class GroupsService {
	private url = 'http://localhost:8080/SpringCore/groups/';

  constructor(private http: HttpClient) { }

  getGroupsForUser(userID: string): Observable<Groups[]> {
    return this.http.get<Groups[]>(this.url + userID)
    .pipe(
      catchError(this.handleError<Groups[]>('getCards', [])));
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
