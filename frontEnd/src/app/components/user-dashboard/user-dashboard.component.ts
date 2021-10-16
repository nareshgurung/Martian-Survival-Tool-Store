import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GroupsService } from 'src/app/service/groups/groups.service';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  uName: string = "Null";
  userID:number = -1;
  wishlist: number = -1;

  constructor(private router:Router,private groupService: GroupsService) { }

  ngOnInit(): void {
    if(NavbarComponent.userInfo.user_id<0)
      this.router.navigateByUrl("/login");

    this.userID = NavbarComponent.userInfo.user_id;
    this.uName = NavbarComponent.userInfo.user_fname;
    this.findWishlist();
  }

  findWishlist(){
    // this.groupService.getGroupsForUser(id).subscribe(groups => this.groups = groups);
    this.groupService.getWishlistForUser(this.userID).subscribe(wishlist => this.wishlist = wishlist);
  }
}
