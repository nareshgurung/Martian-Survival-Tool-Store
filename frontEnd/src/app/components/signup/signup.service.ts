import { HttpClient } from '@angular/common/http';
import { ThrowStmt } from '@angular/compiler';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  signUpUser ="http://localhost:8080/SpringCore/users/signup"

  constructor(private http:HttpClient) { }

  signupSetup(newUser:object){
    return  this.http.post(this.signUpUser, newUser);
    
  }
}
