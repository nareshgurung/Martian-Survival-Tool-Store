import { Component, Input } from '@angular/core';
import { CartService } from 'src/app/service/cart/cart.service';
import { Product } from 'src/app/models/product';
import { NavbarComponent } from '../navbar/navbar.component';

export interface addressAndPayment {
  email:string;
  name:string;
  address:string;
  zip:number;
  city:string;
  state:string;
  card:number;
  exp:string;
  code:number;
  }

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})

export class CartComponent {
@Input() product? : Product;

items:Product[] = [];
frm:addressAndPayment = {email:"", name:"",address:"",card:-1,city:"",code:-1,exp:"",state:"",zip:-1};

  constructor(
    private cartService: CartService  
    ) {}

  ngOnInit() {
    this.items = this.cartService.getItems();
  }

  confirmationMsg:boolean = false;

  showMessage() {
    this.confirmationMsg = !this.confirmationMsg;
  }

  fillObject(){

  }

  onSubmit(): void {
    this.showMessage();
    this.cartService.orderItems(this.items,this.frm,NavbarComponent.userInfo.user_id).subscribe();
    this.items = this.cartService.clearCart();
  }
}
