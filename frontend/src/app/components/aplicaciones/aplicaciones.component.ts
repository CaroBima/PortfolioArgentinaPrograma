import { Component, OnInit } from '@angular/core';

//servicios
import { AplicacionesService } from '../../services/aplicaciones.service';
import { Aplicacion } from '../../models/aplicacion';

@Component({
  selector: 'app-aplicaciones',
  templateUrl: './aplicaciones.component.html',
  styleUrls: ['./aplicaciones.component.css'],
})
export class AplicacionesComponent implements OnInit {
  aplicaciones: Aplicacion[] = [];
  constructor(private _aplicacionesService: AplicacionesService) {}

  ngOnInit(): void {
    this.traerAplicaciones(); //trae todas las aplicaciones almacenadas
  }

  //trae todas las aplicaciones almacenadas
  public traerAplicaciones() {
    this._aplicacionesService.getAplicaciones().subscribe((respuesta) => {
      respuesta.forEach((x) => {
        this.aplicaciones.push(x);
      });
      return respuesta;
    });
  }
}
