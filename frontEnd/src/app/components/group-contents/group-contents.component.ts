import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GroupContents } from 'src/app/models/group_contents';
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/service/cart.service';
import { GroupContentsService } from 'src/app/service/group_contents/group-contents.service';
import { ProductsService } from 'src/app/service/products/products.service';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-group-contents',
  templateUrl: './group-contents.component.html',
  styleUrls: ['./group-contents.component.css']
})
export class GroupContentsComponent implements OnInit {
groupContents: GroupContents[] = [];
currentPage:string = "";
loggedIn:boolean = false;

  constructor(private rout: ActivatedRoute, private groupContentsService: GroupContentsService, private cart:CartService, private prodService:ProductsService) { }

  ngOnInit(): void {
    this.getGroupedItemsForUser();
    this.currentPage = window.location.toString();
    if(NavbarComponent.userInfo.user_id>0){
      this.loggedIn=true;
    }
  }

  getGroupedItemsForUser(): void {
    const userID = Number(this.rout.snapshot.paramMap.get('userID'));
    const groupID = Number(this.rout.snapshot.paramMap.get('groupID'));
    this.groupContentsService.getGroupedItemsForUser(userID, groupID).subscribe(groupContents => this.groupContents = groupContents);
  }

  addAllToCart(){
    for(let i of this.groupContents){
      this.prodService.getProductsByID(i.product_id).subscribe(elephant => {
        this.cart.addToCart(elephant);
      });
    }
    window.alert(`You added the entire list to your cart!`)
  }
  addItemToCart(productID:number){
    this.prodService.getProductsByID(productID).subscribe(elephant => {
      this.cart.addToCart(elephant);
      window.alert(`You added a ${elephant.product_name} to your cart!`)
    });
  }

  removeFromGroup(productID:number){
    const groupID = Number(this.rout.snapshot.paramMap.get('groupID'));
    this.groupContentsService.removeItemFromGroup(groupID,productID).subscribe()
  }

}
