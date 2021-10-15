import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {Login } from './login';

export interface LoginResponse{
  user_id:number;
  user_fname:string;
  user_lname:string;
  user_username:string;
  user_password:string;

}
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  subscribe(): string {
    throw new Error('Method not implemented.');
  }

  error:string=""

  user = new Subject<Login>();

  constructor(private httpClient:HttpClient) { }
  

  login(username:string, password:string){
    
   return this.httpClient.post<LoginResponse>(`http://localhost:8080/SpringCore/users/login/${username}/${password}`, []
   ).pipe(catchError(errorRes =>{
     let errorMessage = "anknown error occured"
      this.error="invalid username"
      console.log(errorRes);
      return throwError(errorMessage);   
   }
   ), tap(respo=>{
     const usr = new Login(respo.user_id, respo.user_fname, respo.user_lname,
                  username, password)
      this.user.next(usr);
   }));
  }
  logout(){
    this.user.next();
  }
 
}


