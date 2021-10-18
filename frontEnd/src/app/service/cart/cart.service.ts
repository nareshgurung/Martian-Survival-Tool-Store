import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { addressAndPayment } from '../../components/cart/cart.component';
import { Product } from '../../models/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private url = 'http://52.14.63.20:8088/martiantools/cart/add';

  static items: Product[] =[];

  constructor(private http: HttpClient, private router:Router) { }

  orderItems(items: Product[], frm: addressAndPayment, userID:number):Observable<boolean> {
    console.log("called the server")
    return this.http.post<boolean>(this.url, {frm,items,userID})
    .pipe(
      catchError(this.handleError<boolean>('getCards')));
  }

  addToCart(product: Product) {
      CartService.items.push(product);
    }

    getItems():Product[] {
      return CartService.items;
    }

    clearCart() {

      CartService.items = [];
      return CartService.items;
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
    this.router.navigateByUrl('error');
    return of(result as T);
  };
}  }
