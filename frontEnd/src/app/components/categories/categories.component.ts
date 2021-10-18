import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { Card } from '../../models/card';
import { CardService } from '../../service/category-card/card.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  cards: Card[] = [];
  mostSold:Product[] = [];

  constructor(private cardService: CardService, private router: Router) { }

  ngOnInit(): void {
    this.getCategories();
    this.getMostSold();
  }

  getMostSold():void {
    this.cardService.getMostSold().subscribe(jasmine => this.mostSold = jasmine)
  }

  getCategories(): void {
    this.cardService.getCards().subscribe(cards => this.cards = cards);
    if(this.cards){
      
    } else {
      this.router.navigateByUrl('../error');
    }
  }

}
