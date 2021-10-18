import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Card } from '../../models/card';
import {catchError, map, tap} from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CardService {
private url = 'http://localhost:8080/martiantools/categories/all';

  constructor(private http: HttpClient, private router:Router) { }

  getCards(): Observable<Card[]> {
    return(this.http.get<Card[]>(this.url)
    .pipe(
      catchError(this.handleError<Card[]>('getCards', []))));
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
}
}
