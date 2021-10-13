import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Groups } from 'src/app/models/groups';
import { GroupsService } from 'src/app/service/groups/groups.service';

@Component({
  selector: 'app-groups',
  templateUrl: './groups.component.html',
  styleUrls: ['./groups.component.css']
})
export class GroupsComponent implements OnInit {
groups: Groups[] = [];

  constructor(private rout: ActivatedRoute, private groupService: GroupsService) { }

  ngOnInit(): void {
    this.getGroups();
  }

  getGroups(): void {
    const id = Number(this.rout.snapshot.paramMap.get('userID'));
    this.groupService.getGroupsForUser(id).subscribe(groups => this.groups = groups);
  }


}
