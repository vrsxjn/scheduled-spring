import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {
  @Input() data: any; 

  constructor(private dialog: MatDialog) {
  }



}