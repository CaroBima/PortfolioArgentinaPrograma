import { Component, OnInit } from '@angular/core';
import { TecnologiasService } from 'src/app/services/tecnologias.service';
import { ITecnologia } from '../../models/Tecnologia';

@Component({
  selector: 'app-nuevocurso',
  templateUrl: './nuevocurso.component.html',
  styleUrls: ['./nuevocurso.component.css'],
})
export class NuevocursoComponent implements OnInit {
  public tecnologiasArray: ITecnologia[] = [];

  constructor(private _tecnologiasService: TecnologiasService) {}

  ngOnInit(): void {
    this.traerTecnologias();
    console.log(this.tecnologiasArray);
  }

  //borra el valor del option de tecnologias
  public limpiarSeleccion() {
    console.log('don barredora soy');
  }

  public traerTecnologias() {
    this._tecnologiasService.getTecnologias().subscribe((respuesta) => {
      respuesta.forEach((resp) => {
        this.tecnologiasArray.push(resp);
      });
      return respuesta;
    });
  }
}
