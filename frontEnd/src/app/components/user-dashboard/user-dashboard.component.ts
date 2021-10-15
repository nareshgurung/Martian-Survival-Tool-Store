import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  uName: string = "Null";

  constructor(private router:Router) { }

  ngOnInit(): void {
    if(NavbarComponent.userInfo.user_id<0)
      this.router.navigateByUrl("/login");
    
    this.uName = NavbarComponent.userInfo.user_fname;
  }

}
