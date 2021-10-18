import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
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
   return this.httpClient.post<Users>(`http://52.14.63.20:8088/martiantools/users/login/${username}/${password}`, []);
  }

  logout(){
    this.user.next();
  }
 
}


