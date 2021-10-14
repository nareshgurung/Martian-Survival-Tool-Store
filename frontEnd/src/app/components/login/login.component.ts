import { HttpClient } from '@angular/common/http';
import { ThisReceiver, ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { Login } from 'src/app/service/login';
import { LoginResponse, LoginService } from 'src/app/service/login.service';
import { UserDashboardComponent } from '../user-dashboard/user-dashboard.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    error:string="";
    username:string="";
    password:string="";
    invalidLogin = false;


  constructor(private loginServ:LoginService, private router:Router) { }



  ngOnInit(): void {

  }


  checkLogin(){ 
      
 let authObs: Observable<LoginResponse>;

    authObs = this.loginServ.login(this.username, this.password)

    authObs.subscribe(
      resData=>{
        if(resData != null){
          // this.error=`Welcome ${resData.user_fname} ${resData.user_lname} `;
          this.router.navigate(['/dashboard'])
          // console.log(resData);
        }else if(resData == null){
          this.error="Invalid Credentials"
        }
      },
      errorMessage=>{
         this.error="invalid Credentials"
        //  console.log(errorMessage);
      }
    );
    
  }
}
