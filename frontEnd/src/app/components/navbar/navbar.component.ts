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
  ngOnInit() {
   this.userSub = this.loginServ.user.subscribe(user=>{
    this.isLoggedin =!user ? false : true; 
    this.fname=user.user_fname;
   });
  }
  onlogout(){
    this.loginServ.logout();
  }
}
