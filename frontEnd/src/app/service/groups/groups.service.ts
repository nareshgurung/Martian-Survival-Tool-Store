import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import { Groups } from 'src/app/models/groups';

@Injectable({
  providedIn: 'root'
})
export class GroupsService {
	private url = 'http://localhost:8080/SpringCore/groups/';

  constructor(private http: HttpClient, private router: Router) { }

  getGroupsForUser(userID: number): Observable<Groups[]> {
    return this.http.get<Groups[]>(this.url + userID)
    .pipe(
      catchError(this.handleError<Groups[]>('getCards', [])));
  }

  getWishlistForUser(userID: number): Observable<number> {
    return this.http.get<number>(this.url + "wishlist/" + userID)
    .pipe(
      catchError(this.handleError<number>('getCards')));
  }

  addGroup(userID: number, groupName: string): Observable<boolean> {
    return this.http.post<boolean>(`${this.url}addNewGroup/${userID}/${groupName}`, null)
    .pipe(
      catchError(this.handleError<boolean>('getCards')));
  }

  deleteGroup(userID: number, groupID: number): Observable<boolean> {
    return this.http.post<boolean>(`${this.url}deletegroup/${userID}/${groupID}`, null)
    .pipe(
      catchError(this.handleError<boolean>('getCards')));
  }

  renameGroup(userID:number, groupID:number, groupName:string): Observable<boolean> {
    return this.http.post<boolean>(`${this.url}renameGroup/${userID}/${groupID}/${groupName}`, null)
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
