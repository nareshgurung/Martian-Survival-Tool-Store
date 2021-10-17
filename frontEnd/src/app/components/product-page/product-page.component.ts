import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/service/products/products.service';
import { CartService } from 'src/app/service/cart.service';
import { NavbarComponent } from '../navbar/navbar.component';
import { WishListService } from 'src/app/service/wish/wish-list.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {
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
    private cartService:CartService, private wish:WishListService) { }

  ngOnInit(): void {
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

}
