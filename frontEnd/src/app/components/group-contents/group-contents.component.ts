import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Card } from 'src/app/models/card';
import { GroupContents } from 'src/app/models/group_contents';
import { Product } from 'src/app/models/product';
import { GroupContentsService } from 'src/app/service/group_contents/group-contents.service';

@Component({
  selector: 'app-group-contents',
  templateUrl: './group-contents.component.html',
  styleUrls: ['./group-contents.component.css']
})
export class GroupContentsComponent implements OnInit {
groupContents: GroupContents[] = [];

  constructor(private rout: ActivatedRoute, private groupContentsService: GroupContentsService) { }

  ngOnInit(): void {
    this.getGroupedItemsForUser();
  }

  getGroupedItemsForUser(): void {
    const userID = Number(this.rout.snapshot.paramMap.get('userID'));
    const groupID = Number(this.rout.snapshot.paramMap.get('groupID'));
    this.groupContentsService.getGroupedItemsForUser(userID, groupID).subscribe(groupContents => this.groupContents = groupContents);
  }
}
