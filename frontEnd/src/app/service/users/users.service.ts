import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
	private url = 'http://localhost:8080/';

  constructor(private http: HttpClient, private router:Router) { }

  getGroupedItemsForUser(userID: number, groupID: number): Observable<boolean>{
    return this.http.post<boolean>(this.url + userID + "/" + groupID, null)
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
