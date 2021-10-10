import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


    loginUrl="http://localhost:8080/SpringCore/users/login";

  constructor(private httpClient:HttpClient) { }


 

  login(username:string, password:string):Observable<any>{
    
    return this.httpClient.post(`http://localhost:8080/SpringCore/users/login/${username}/${password}`, []);
  
  }
  
}


