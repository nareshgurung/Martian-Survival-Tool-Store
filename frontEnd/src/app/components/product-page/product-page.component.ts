import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/service/products/products.service';
import { CartService } from 'src/app/service/cart.service';
import { NavbarComponent } from '../navbar/navbar.component';

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

  constructor(private rout: ActivatedRoute, private prodService:ProductsService,
    private cartService:CartService) { }

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

  selectedProduct? : Product;
  onSelect(product: Product): void {
    this.selectedProduct = product;
  }

}
