import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    username:string="";
    password:string="";
    invalidLogin = false;
  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
   
  }



  checkLogin(){
    if(this.loginService.login(this.username, this.password)){
        this.invalidLogin = false;
        console.log("welcome");
    }
    else{
      this.invalidLogin = true;
      console.log("no");
    }
  }


}
