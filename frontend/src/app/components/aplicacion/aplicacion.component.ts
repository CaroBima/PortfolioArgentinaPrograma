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
  aplicacion: Aplicacion;
  idProyecto: number = 0;

  constructor(
    private rutaActiva: ActivatedRoute,
    private _aplicacionesService: AplicacionesService
  ) {
    this.aplicacion = this.rutaActiva.snapshot.params['app'];
    //trae los parametros
    /*this.activatedRoute.params.subscribe(
      (params) =>
        (this.idProyecto = _aplicacionesService.getAplicacion(
          params['app.idProyecto']
        ))
    );*/
  }

  ngOnInit(): void {
    this.idProyecto = this.rutaActiva.snapshot.params['app'];

    this.rutaActiva.params.subscribe((params: Params) => {
      this.idProyecto = params['app'];
    });
    console.log(this.aplicacion);
  }

  //trae el proyecto pasando el id por parametro
  public traerProyecto(idProyecto: number) {
    console.log('entra al metodo traer proyecto');
    this._aplicacionesService
      .getAplicacion(idProyecto)
      .subscribe((respuesta) => {
        this.aplicacion = respuesta;
        console.log(this.aplicacion);
        console.log(this.aplicacion);
      });
  }

  /*
public traerAplicaciones() {
    this._aplicacionesService.getAplicaciones().subscribe((respuesta) => {
      respuesta.forEach((x) => {
        this.aplicaciones.push(x);
        console.log(x);
      });
      return respuesta;
    });
  }
  */
}
