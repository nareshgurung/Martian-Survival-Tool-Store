import { Component, OnInit } from '@angular/core';
import { Card } from '../category-card/card';
import { CardService } from '../category-card/card.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
 cards: Card[] = [];

  constructor(private cardService: CardService) { }

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories(): void {
    this.cardService.getCards().subscribe(cards => this.cards = cards);
  }

}