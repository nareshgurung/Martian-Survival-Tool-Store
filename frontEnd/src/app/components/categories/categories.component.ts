import { Component, OnInit } from '@angular/core';
import { GenericCard } from '../../models/card';
import { CardService } from '../../service/category-card/card.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
 cards: GenericCard[] = [];

  constructor(private cardService: CardService) { }

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories(): void {
    this.cardService.getCards().subscribe(cards => this.cards = cards);
  }

}
