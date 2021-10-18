import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { PurchasedItems } from 'src/app/models/purchased-items';

@Injectable({
  providedIn: 'root'
})
export class OrderInventoryService {
	private url = 'http://52.14.63.20:8088/martiantools/pItem/';

  constructor(private http: HttpClient, private router: Router) { }

  getItemsWithGroupID(groupID:number):Observable<PurchasedItems[]> {
    return this.http.get<PurchasedItems[]>(this.url + groupID)
    .pipe(
      catchError(this.handleError<PurchasedItems[]>('getCards', [])));
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
