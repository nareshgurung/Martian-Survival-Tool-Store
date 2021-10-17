import { Component, Input, OnInit } from '@angular/core';
import { PurchasedItems } from 'src/app/models/purchased-items';
import { OrderInventoryService } from 'src/app/service/OrderInventory/order-inventory.service';

@Component({
  selector: 'app-order-inventory',
  templateUrl: './order-inventory.component.html',
  styleUrls: ['./order-inventory.component.css']
})
export class OrderInventoryComponent implements OnInit {
  @Input() groupID:number = -1;
  items:PurchasedItems[] = [];

  constructor(private invService:OrderInventoryService) { }

  ngOnInit(): void {
    this.fillItems();
  }

  fillItems(){
    this.invService.getItemsWithGroupID(this.groupID).subscribe(item => this.items = item);
  }
}
