import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  deleteGroup(groupID:number): void {
    let wasDeleted: boolean = false;
    this.groupService.deleteGroup(NavbarComponent.userInfo.user_id, groupID).subscribe(signedBool => wasDeleted = signedBool)
    if(!wasDeleted) {
      window.alert("Group was deleted");
      this.router.navigateByUrl('/error').then(
        () => this.router.navigateByUrl('/editgroups')
      );
      } else 
      window.alert("Something went wrong and your group was not deleted. Were you trying to delete your wishlist?");
  }

  changeGroupName(groupID:number): void {
    const newGroupName:string = "" + window.prompt("Please enter a new name for the group. Please note that you cannot change the name of your wishlist");
    let wasRenamed: boolean = false;
    this.groupService.renameGroup(NavbarComponent.userInfo.user_id, groupID, newGroupName).subscribe(signedBool => wasRenamed = signedBool)
    if(!wasRenamed) {
      window.alert("Group was re-named");
      this.router.navigateByUrl('/error').then(
        () => this.router.navigateByUrl('/editgroups')
      );
      } else 
      window.alert("Something went wrong and your group was not re-named. Were you trying to re-name your wishlist?");  }

}
