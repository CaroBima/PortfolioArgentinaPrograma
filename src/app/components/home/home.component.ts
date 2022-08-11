import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  public show: boolean[] = [];
  //public showOrNot: string;
  constructor() {
    //this.showOrNot = 'Mostrar';
    this.show = [false, false];
  }

  ngOnInit(): void {}

  showData(cualMostrar: string) {
    /*if (this.show) {
      this.showOrNot = valor;
    } else {
      this.showOrNot = `Ocultar ${valor}`;
    }*/
    switch (cualMostrar) {
      case 'dedonde':
        this.show[0] = !this.show[0];
        break;
      case 'formacion':
        this.show[1] = !this.show[1];
        break;
    }
  }
}
