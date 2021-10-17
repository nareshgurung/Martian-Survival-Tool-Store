import { Injectable } from '@angular/core';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  static items: Product[] =[];

  constructor() { }

    addToCart(product: Product) {
      CartService.items.push(product);
    }

    getItems():Product[] {
      return CartService.items;
    }

    clearCart() {
      console.log("inside clear cart")
      CartService.items = [];
      return CartService.items;
    }
}
