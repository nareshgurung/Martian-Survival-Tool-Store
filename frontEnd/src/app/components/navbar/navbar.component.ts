import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { Login } from 'src/app/service/login';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy {

  isLoggedin = false;
  private userSub: Subscription = new Subscription;
 
  constructor(private loginServ:LoginService) {
   }



  ngOnDestroy(): void {
   this.userSub.unsubscribe();
  }

fname:string="";
userId:number=0;
userPassword:string="";

  ngOnInit() {
   this.userSub = this.loginServ.user.subscribe(user=>{
    this.isLoggedin =!user ? false : true; 
    this.fname=user.user_fname;
    this.userId=user.user_id;
    this.userPassword=user.user_password;
   });
  }
  
  onlogout(){
    this.loginServ.logout();
  }
}
