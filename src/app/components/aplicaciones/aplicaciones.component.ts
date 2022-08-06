import { Component, OnInit } from '@angular/core';

//servicios
import { AplicacionesService } from '../../services/aplicaciones.service';

@Component({
  selector: 'app-aplicaciones',
  templateUrl: './aplicaciones.component.html',
  styleUrls: ['./aplicaciones.component.css'],
})
export class AplicacionesComponent implements OnInit {
  aplicaciones: any[] = [];
  constructor(private _aplicacionesService: AplicacionesService) {}

  ngOnInit(): void {
    this.aplicaciones = this._aplicacionesService.getAplicaciones();
  }
}
