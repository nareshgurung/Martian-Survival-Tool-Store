import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Users } from 'src/app/models/Users';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  constructor(private alertService: LoginService) { 
    const allUsers = alertService.getAll();
    
  }

  ngOnInit(): void {
    this.alertService.getAll().subscribe(user => console.log(user))
  }

  @Input()
  user: Users | any;
  

  // @Output()
  // updateCardEvent = new EventEmitter<Users>();

  // //dummy card that is emitted and passed up to the parent
  // udateUsers:Users = new Users(1, 'emitted recipe', 'emitted description', 'emitted url', 'emitted step');

  // updateCardState(){
  //   this.updateCardEvent.emit(this.updatedCard);
  // }


}
