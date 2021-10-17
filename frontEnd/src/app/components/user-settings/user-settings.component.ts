import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from 'src/app/models/Users';
import { UsersService } from 'src/app/service/users/users.service';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-user-settings',
  templateUrl: './user-settings.component.html',
  styleUrls: ['./user-settings.component.css']
})
export class UserSettingsComponent implements OnInit {
  user: Users = new Users(-1,1," "," "," "," "," ",1," "," "," ","");
  role:string = "";

  constructor(private userService:UsersService, private router:Router) { }

  ngOnInit(): void {
    this.user.setUserWithUsers(NavbarComponent.userInfo);
    if(NavbarComponent.userInfo.user_id<0)
      this.router.navigateByUrl("/login");
    this.setRole();
  }

  setRole(){
    if(NavbarComponent.userInfo.user_role<1) {
      this.role = "Valued Customer";
    } else {
      this.role = "Valued Supplier";
    }
  }

  sendOff(): void {
    var tf = false;
    this.userService.update(this.user).subscribe(item => tf = item);

    if(tf) {
      this.router.navigateByUrl('/error').then(
        () => this.router.navigateByUrl('/settings')
      );
    }

  }

  Cancel(): void {
    this.router.navigateByUrl("/dashboard");
  }
  updatePassword():void {
    this.user.user_password = "" + window.prompt("New Value");
  }
  updateUsername():void {
    this.user.user_username = "" + window.prompt("New Value");
  }
  updateState():void {
    this.user.user_state = "" + window.prompt("New Value");
  }
  updateCity():void {
    this.user.user_city = "" + window.prompt("New Value");
  }
  updateZip():void {
    this.user.user_zip = Number(window.prompt("New Value"));
  }
  updateStreet():void {
    this.user.user_street = "" + window.prompt("New Value");
  }
  updatelName():void {
    this.user.user_lname = "" + window.prompt("New Value");
  }
  updateMI():void {
    this.user.user_midinnitial = "" + window.prompt("New Value");
  }
  updatefName():void {
    this.user.user_fname = "" + window.prompt("New Value");
  }
  updateEmail():void {
    this.user.user_email = "" + window.prompt("New Value");
  }
}
