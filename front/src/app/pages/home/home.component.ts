import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Post } from '../components/card/data.mode';
import { Data } from '@angular/router';

let userInfor: any = [];


const api = {
 
  getData: () => {
    const dataInfo = 'http://localhost:8080/api/participants';
    return fetch(dataInfo, {
      
      })
      .then((response) => response.json()); 
  }
};


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],

})



export class HomeComponent {
  datas: Data[] = [];
  constructor(private dialog: MatDialog) { }
  
  ngOnInit() {
    api.getData().then((datas) => {
      this.datas = datas; 
    });
  }


}