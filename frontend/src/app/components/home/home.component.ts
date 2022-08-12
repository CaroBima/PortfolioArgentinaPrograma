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
    this.show = [false, false, false];
  }

  ngOnInit(): void {}

  showData(cualMostrar: string) {
    /*if (this.show) {
      this.showOrNot = valor;
    } else {
      this.showOrNot = `Ocultar ${valor}`;
    }*/
    //por el momento al ser pocas opciones lo dejo con un switch, seteando a false los otros botones
    switch (cualMostrar) {
      case 'dedonde':
        this.show[0] = !this.show[0];
        this.show[1] = false;
        this.show[2] = false;
        break;
      case 'formacion':
        this.show[0] = false;
        this.show[1] = !this.show[1];
        this.show[2] = false;
        break;
      case 'trabajo':
        this.show[0] = false;
        this.show[1] = false;
        this.show[2] = !this.show[2];
        break;
    }
  }
}
