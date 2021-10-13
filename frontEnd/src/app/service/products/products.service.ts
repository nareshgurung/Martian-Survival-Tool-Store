import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Product } from 'src/app/models/product';
import {catchError, map, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  private url = 'http://localhost:8080/SpringCore/products/';

  constructor(private http: HttpClient) { }

  getProducts(id: number): Observable<Product[]>{
    return this.http.get<Product[]>(this.url + "all/" + id)
  }

  getProductsByID(productID: number): Observable<Product[]>{
    return this.http.get<Product[]>(this.url + "id/" + productID)
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
