import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Users } from '../models/Users';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient:HttpClient) { }

  getAll():Observable<Users[]>{
    
    return this.httpClient.get(environment.getAll) as Observable<Users[]>;


  }

  login(username:string, password:string){
    if(username === "javainuse" && password === "password"){
      // sessionStorage.setItem("username", username)
      return true;
    }else{
      return false;
    }
  }
  // isUserLoggedIn(){
  //   let user = sessionStorage.getItem('username')
  //   console.log(!(user === null))
  //   return !(user === null)
  // }
}


