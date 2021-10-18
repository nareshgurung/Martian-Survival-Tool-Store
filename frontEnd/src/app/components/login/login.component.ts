import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { Users } from 'src/app/models/Users';
import { LoginService } from 'src/app/service/login.service';
import { NavbarComponent } from '../navbar/navbar.component';

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
    invalidMsg:boolean = false;


  constructor(private loginServ:LoginService, private router:Router) { }

  ngOnInit(): void {

  }

  checkLogin(){

 let authObs: Observable<Users>;
    authObs = this.loginServ.login(this.username, this.password)

    authObs.subscribe(
      resData=>{
        if(resData != null){
          NavbarComponent.userInfo = resData;
          this.router.navigate(['/dashboard'])
        }else if(resData == null){

          this.invalidMsg = !this.invalidMsg;
          // this.error="Invalid Credentials"
        }
      },
      errorMessage=>{
        //  this.error="invalid Credentials"
        this.invalidMsg = !this.invalidMsg;
      }
    );

  }
}
