import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { PurchaseGroup } from 'src/app/models/purchase-group';

@Injectable({
  providedIn: 'root'
})
export class PurchaseGroupsService {
  private url = 'http://localhost:8080/SpringCore/pGroup/';

  constructor(private http: HttpClient) { }

  getUsersGroups(userID:number): Observable<PurchaseGroup[]> {
    return this.http.get<PurchaseGroup[]>(this.url + userID)
    .pipe(
      catchError(this.handleError<PurchaseGroup[]>('getCards')));
  }

   /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
