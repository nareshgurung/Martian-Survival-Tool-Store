import { Component, OnDestroy, OnInit } from '@angular/core';
import { Users } from 'src/app/models/Users';
import { Router, NavigationStart, Event as NavigationEvent } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy {

  static userInfo:Users = new Users(-1,1," "," "," "," "," ",1," "," "," ","");
  isLoggedin = false;
  fname:string="";
   
  constructor(private router:Router) {}
  ngOnDestroy(): void {}
  ngOnInit() {

    this.router.events
    .subscribe(
      (event: NavigationEvent) => {
        if(event instanceof NavigationStart) {
          console.log("event:" + event)
          console.log("static fname:" + NavbarComponent.userInfo.user_fname)
          console.log("static lname:" + NavbarComponent.userInfo.user_lname)
          console.log("static id:" + NavbarComponent.userInfo.user_id)
          this.update();
        }
      });

  }

  update(){
    if(NavbarComponent.userInfo.user_id>0) {
      this.isLoggedin=true;
      this.fname = NavbarComponent.userInfo.user_fname;
    }
  }

  
}