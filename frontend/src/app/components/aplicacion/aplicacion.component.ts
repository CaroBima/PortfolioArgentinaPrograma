import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AplicacionesService } from 'src/app/services/aplicaciones.service';

@Component({
  selector: 'app-aplicacion',
  templateUrl: './aplicacion.component.html',
  styleUrls: ['./aplicacion.component.css'],
})
export class AplicacionComponent implements OnInit {
  aplicacion: any = {};

  constructor(
    private activatedRoute: ActivatedRoute,
    private _aplicacionesService: AplicacionesService
  ) {
    this.activatedRoute.params.subscribe(
      (params) =>
        (this.aplicacion = _aplicacionesService.getAplicacion(params['id']))
    );
  }

  ngOnInit(): void {}
}
