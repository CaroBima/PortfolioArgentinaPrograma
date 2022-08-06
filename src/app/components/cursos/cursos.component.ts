import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

import { ICursoInterface } from 'src/app/models/CursoInterface';
import { CursosService } from 'src/app/services/cursos.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
})
export class CursosComponent implements OnInit {
  cursos: ICursoInterface[] = [];
  buscador: any;
  constructor(private _cursosService: CursosService) {}

  ngOnInit(): void {
    this.cursos = this._cursosService.getCursos();
  }

  //permite traer los cursos de acuerdo al string escrito en el buscador
  public buscarTecnologia(tecnologia: string) {
    this.cursos = this._cursosService.buscadorCurso(tecnologia);
  }

  //metodo del boton busqueda para limpiar la busqueda y traer todos los cursos nuevamente
  limpiarBusqueda() {
    this.cursos = this._cursosService.getCursos();
    this.buscador = '';
  }
}
