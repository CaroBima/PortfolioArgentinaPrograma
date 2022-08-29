import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { AplicacionesService } from 'src/app/services/aplicaciones.service';
import { Aplicacion } from '../../models/aplicacion';

@Component({
  selector: 'app-aplicacion',
  templateUrl: './aplicacion.component.html',
  styleUrls: ['./aplicacion.component.css'],
})
export class AplicacionComponent implements OnInit {
  aplicacion: any;
  idProyecto: number = 0;
  arrayImagenes: any[] = [];

  constructor(
    private rutaActiva: ActivatedRoute,
    private _aplicacionesService: AplicacionesService
  ) {
    this.aplicacion = this.rutaActiva.snapshot.params['app'];
  }

  ngOnInit(): void {
    //traigo el id pasado por parametro en el routerlink
    this.idProyecto = this.rutaActiva.snapshot.params['app'];

    this.rutaActiva.params.subscribe((params: Params) => {
      this.idProyecto = params['app'];
    });

    //traigo el proyecto cuya id se paso por parametro
    this.traerProyecto(this.idProyecto);
  }

  //trae el proyecto pasando el id por parametro
  public traerProyecto(idProyecto: number) {
    this._aplicacionesService
      .getAplicacion(idProyecto)
      .subscribe((respuesta) => {
        this.aplicacion = respuesta;
        //this.arrayImagenes = respuesta.imagenes;
        respuesta.imagenes.forEach((x) => {
          this.arrayImagenes.push(x);
          console.log(x);
        });

        console.log(this.aplicacion);
        console.log(this.aplicacion.imagenes);
      });
  }

  //para obtener los temas y las tecnolgias
  public obtenerValorPorPosicion(obj: any, posicion: number): any {
    return Object.keys(obj)[posicion];
  }
}
