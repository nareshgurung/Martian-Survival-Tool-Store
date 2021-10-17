import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/service/products/products.service';
import { CartService } from 'src/app/service/cart.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {
  products: Product[] = [];

  constructor(private rout: ActivatedRoute, private prodService: ProductsService,
    private cartService: CartService) { }

  ngOnInit(): void {
    this.getProductByID();
  }

  getProductByID(): void {
    const id = Number(this.rout.snapshot.paramMap.get('id'));
    this.prodService.getProductsByID(id).subscribe((products: Product[]) => this.products = products);
  }

  addToCart(product: Product) {
    this.cartService.addToCart(product);
  }

selectedProduct? : Product;
onSelect(product: Product): void {
  this.selectedProduct = product;
}

}
