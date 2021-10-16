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
          this.update();
        }
      });

  }

  update(){
    this.fname = NavbarComponent.userInfo.user_fname;
    if(NavbarComponent.userInfo.user_id>0)
      this.isLoggedin=true;
    else
      this.isLoggedin=false;
  }

  
}