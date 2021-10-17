import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PurchaseGroup } from 'src/app/models/purchase-group';
import { PurchaseGroupsService } from 'src/app/service/PurchaseGroups/purchase-groups.service';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-previous-orders',
  templateUrl: './previous-orders.component.html',
  styleUrls: ['./previous-orders.component.css']
})
export class PreviousOrdersComponent implements OnInit {
groups:PurchaseGroup[] = [];


  constructor(private rout: ActivatedRoute, private purchaseService:PurchaseGroupsService) { }

  ngOnInit(): void {
    this.getPurchaseGroups();
  }

  getPurchaseGroups(){
    this.purchaseService.getUsersGroups(NavbarComponent.userInfo.user_id).subscribe(group=> this.groups = group);
  }
}
