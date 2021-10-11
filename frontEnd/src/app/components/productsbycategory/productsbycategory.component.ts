import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/service/products/product';
import { ProductsService } from 'src/app/service/products/products.service';

@Component({
  selector: 'app-productsbycategory',
  templateUrl: './productsbycategory.component.html',
  styleUrls: ['./productsbycategory.component.css']
})
export class ProductsbycategoryComponent implements OnInit {
  products: Product[] = [];

  constructor(private rout: ActivatedRoute, private prodService: ProductsService) { }

  ngOnInit(): void {
    this.getProductsByID();
  }

  getProductsByID(): void {
    const id = Number(this.rout.snapshot.paramMap.get('id'));
    this.prodService.getProducts(id).subscribe(products => this.products = products);
  }

}
