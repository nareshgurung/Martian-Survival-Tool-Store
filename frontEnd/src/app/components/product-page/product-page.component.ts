import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/service/products/products.service';
import { CartService } from 'src/app/service/cart/cart.service';
import { NavbarComponent } from '../navbar/navbar.component';
import { WishListService } from 'src/app/service/wish/wish-list.service';
import { Groups } from 'src/app/models/groups';
import { GroupsService } from 'src/app/service/groups/groups.service';
import { GroupContentsService } from 'src/app/service/group_contents/group-contents.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {
  groups: Groups[] = [];
  isLoggedIn = false;
  selectedLevel:any;
  prod: Product = {
    product_id: -1,
    product_name: "",
    product_description: "",
    product_price: -1,
    product_quantity: -1,
    product_url: "",
    user_id: -1,
    category_id: -1
  }
  commentsArea:boolean = false;
  commentsButtonText = "Comments ↓";
  qna:boolean = false;
  qnaButtonText = "Q & A ↓";

  constructor(private rout: ActivatedRoute, private prodService:ProductsService,
    private cartService:CartService, private wish:WishListService,private groupServ:GroupsService,
    private groupContent:GroupContentsService) {
      this.getGroups();
     }

  ngOnInit(): void {
    this.getGroups();
    this.logSomeoneIn();
    this.getProductByID();
  }

  getProductByID(): void {
    const id = Number(this.rout.snapshot.paramMap.get('id'));
    this.prodService.getProductsByID(id).subscribe((products: Product) => this.prod = products);
  }

  addToCart() {
    this.cartService.addToCart(this.prod);
  }

  addToWishlist() {
    this.wish.addToWishlist(this.prod.product_id, NavbarComponent.userInfo.user_id).subscribe();
    window.alert("Added to your Wishlist!");
  }

  selectedProduct? : Product;
  onSelect(product: Product): void {
    this.selectedProduct = product;
  }

  showComments(){
    if(this.commentsArea) {
      this.commentsArea = false;
      this.commentsButtonText = "Comments ↓";
    } else {
      this.commentsArea = true;
      this.commentsButtonText="Comments ↑";
    }
  }
  showQna(){
    if(this.qna) {
      this.qna = false;
      this.qnaButtonText = "Q & A ↓"
    } else {
      this.qna = true;
      this.qnaButtonText = "Q & A ↑"
    }
  }

  getGroups(): void {
    const id = NavbarComponent.userInfo.user_id;
    console.log("passing id of:" + id);
    this.groupServ.getGroupsForUser(id).subscribe(groups => this.groups = groups);
    for(let g of this.groups){
      console.log("group name:" + g.group_name)
    }
  }

  addToGroup(){
    this.groupContent.addItemToGroup(<number>this.selectedLevel, this.prod.product_id).subscribe();
    window.alert("Item has been added to your group");
  }

  logSomeoneIn():void{
    if(NavbarComponent.userInfo.user_id>0){
      this.isLoggedIn=true;
    }
  }

}
