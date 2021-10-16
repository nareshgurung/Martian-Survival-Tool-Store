import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Groups } from 'src/app/models/groups';
import { GroupsService } from 'src/app/service/groups/groups.service';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-edit-groups',
  templateUrl: './edit-groups.component.html',
  styleUrls: ['./edit-groups.component.css']
})
export class EditGroupsComponent implements OnInit {
  groups:Groups[] = [];

  constructor(private router:Router, private groupService: GroupsService) { }

  ngOnInit(): void {
    this.getGroups();
  }


  getGroups(): void {
    const id = NavbarComponent.userInfo.user_id;
    if(id<0)
      this.router.navigateByUrl("/login");
    this.groupService.getGroupsForUser(id).subscribe(groups => this.groups = groups);
  }

  promptGroupName():void {
    let newGroupName = window.prompt("Please enter a name for the new group");
    
  }

}
