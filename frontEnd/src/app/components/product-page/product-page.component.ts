import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/service/products/products.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {
  products: Product[] = [];

  constructor(private rout: ActivatedRoute, private prodService: ProductsService) { }

  ngOnInit(): void {
    // this.getProductByID();
  }

  // getProductByID(): void {
  //   const id = Number(this.rout.snapshot.paramMap.get('id'));
  //   this.prodService.getProductByID(id).subscribe((products: Product[]) => this.products = products);
  // }


}
