import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/models/Users';
import { SignupService } from './signup.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  

  constructor(private signUpServ:SignupService) { }


  ngOnInit(): void {
  }

  users:Users[]=[];
  user:Users=new Users(0, 0, "", "", "", "", "", 0, "", "", "", "");

  signup(){
    let newUser= new Users(this.user.user_id, this.user.user_role, this.user.user_email, this.user.user_fname, this.user.user_midinnitial, 
                      this.user.user_lname, this.user.user_street, this.user.user_zip, this.user.user_city, this.user.user_state, 
                        this.user.user_username, this.user.user_password);

  this.signUpServ.signupSetup(newUser).subscribe();
  }

}

