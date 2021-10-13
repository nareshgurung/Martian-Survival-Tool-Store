import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GenericCard } from 'src/app/models/card';
import { Product } from 'src/app/models/product';
import { GroupContentsService } from 'src/app/service/group_contents/group-contents.service';

@Component({
  selector: 'app-group-contents',
  templateUrl: './group-contents.component.html',
  styleUrls: ['./group-contents.component.css']
})
export class GroupContentsComponent implements OnInit {
genericCard: GenericCard[] = [];

  constructor(private rout: ActivatedRoute, private groupContentsService: GroupContentsService) { }

  ngOnInit(): void {
  }

  getGroups(): void {
    const userID = Number(this.rout.snapshot.paramMap.get('userID'));
    const groupID = Number(this.rout.snapshot.paramMap.get('groupID'));
    this.groupContentsService.getGroupedItemsForUser(userID, groupID).subscribe(genericCard => this.genericCard = genericCard);
  }
}
