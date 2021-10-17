import { Component, Input } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { CartService } from 'src/app/service/cart.service';
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
@Input() product? : Product;

items:Product[] = [];


  constructor(
    private cartService: CartService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    this.items = this.cartService.getItems();
  }


  checkoutForm = this.formBuilder.group({
    email: '',
    name: '',
    address: '',
    zip: '',
    city: '',
    state: '',

    card:'',
    exp: '',
    code: '',
  });


  confirmationMsg:boolean = false;

  showMessage() {
    this.confirmationMsg = !this.confirmationMsg;
  }

  onSubmit(): void {
    this.items = this.cartService.clearCart();
    this.checkoutForm.reset();
  }
}
