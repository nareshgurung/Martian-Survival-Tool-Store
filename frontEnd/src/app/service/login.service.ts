import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {Login } from './login';
import { Users } from '../models/Users';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  subscribe(): string {
    throw new Error('Method not implemented.');
  }

  error:string=""

  user = new Subject<Users>();

  constructor(private httpClient:HttpClient) { }

  login(username:string, password:string){
   return this.httpClient.post<Users>(`http://localhost:8080/SpringCore/users/login/${username}/${password}`, []);
  }

  logout(){
    this.user.next();
  }
 
}


