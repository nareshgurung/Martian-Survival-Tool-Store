import { Component } from '@angular/core';
import { Users } from './models/Users';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Martian Tools Store';
  userInf:Users = new Users(-1,1," "," "," "," "," ",1," "," "," ","");

  updateUsers($event: Users) {
    this.userInf = $event;
  }
}
