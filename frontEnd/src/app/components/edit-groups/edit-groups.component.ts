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
    const newGroupName:string = "" + window.prompt("Please enter a name for the new group");
    let wasCreated: boolean = false;
    
    // this.groupContentsService.getGroupedItemsForUser(userID, groupID).subscribe(groupContents => this.groupContents = groupContents);
    this.groupService.addGroup(NavbarComponent.userInfo.user_id, newGroupName).subscribe(signedBool => {
      wasCreated = signedBool;
    });
    if(!wasCreated){
      window.alert("Group " +newGroupName+ " was created");
      this.router.navigateByUrl('/error').then(
        () => this.router.navigateByUrl('/editgroups')
      );
    } else {
      window.alert("Group " +newGroupName+ " was not created. It may have the same name as a group you already have.");
    }
  }

}
