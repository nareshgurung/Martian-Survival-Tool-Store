import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Users } from 'src/app/models/Users';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  signUpUser ="http://52.14.63.20:8088/martiantools/users/signup"

  constructor(private http:HttpClient) { }

  signupSetup(newUser:object){
    return  this.http.post<Users>(this.signUpUser, newUser);
    
  }
}
