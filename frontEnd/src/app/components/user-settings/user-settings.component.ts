import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/models/Users';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-user-settings',
  templateUrl: './user-settings.component.html',
  styleUrls: ['./user-settings.component.css']
})
export class UserSettingsComponent implements OnInit {
  user:Users = NavbarComponent.userInfo;
  role:string = "";

  constructor() { }

  ngOnInit(): void {
    this.setRole();
  }

  setRole(){
    if(NavbarComponent.userInfo.user_role<1) {
      this.role = "Valued Customer";
    } else {
      this.role = "Valued Supplier";
    }
  }

  update(whatNeedsToBeUpdated:string):void {
    let newValue:string = "" + window.prompt("New Value");
    
  }

}
