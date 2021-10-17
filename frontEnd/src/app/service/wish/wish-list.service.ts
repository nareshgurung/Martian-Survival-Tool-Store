import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class WishListService {
	private url = 'http://localhost:8080/SpringCore/wishlist/';

  constructor(private http: HttpClient, private router:Router) { }

  addToWishlist(productID:number, userID:number): Observable<boolean>{
    return this.http.post<boolean>(this.url + productID + "/1/" + userID, [])
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
