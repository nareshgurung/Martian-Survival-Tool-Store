import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Users } from 'src/app/models/Users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
	private url = 'http://localhost:8080/SpringCore/users/';

  constructor(private http: HttpClient, private router:Router) { }

  update(user:object): Observable<boolean>{
    console.log("user Email:" + (<Users>user).user_email);
    console.log("URL:" + (`${this.url}update/${(<Users>user).user_id}`))
    return this.http.post<boolean>(`${this.url}update/${(<Users>user).user_id}`, user)
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
