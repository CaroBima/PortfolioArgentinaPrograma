import { Component, OnInit } from '@angular/core';
import { NumberValueAccessor } from '@angular/forms';

import { ICursoInterface } from 'src/app/models/CursoInterface';
import { CursosService } from 'src/app/services/cursos.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
})
export class CursosComponent implements OnInit {
  public cursos: ICursoInterface[] = [];
  buscador: any;
  banderaBusqueda: boolean;
  tecnologia: string;
  constructor(private _cursosService: CursosService) {
    this.banderaBusqueda = false;
    this.tecnologia = '';
  }

  ngOnInit(): void {
    this._cursosService.getCursos().subscribe((respuesta) => {
      respuesta.forEach((x) => {
        this.cursos.push(x);
      });
      return respuesta;
    });
    console.log(this.cursos);
  }

  //permite traer los cursos de acuerdo al string escrito en el buscador
  public buscarTecnologia(tecnologia: string) {
    /*this.cursos = this._cursosService.buscadorCurso(tecnologia);
    this.tecnologia = tecnologia;
    this.banderaBusqueda = true;*/
  }

  //metodo del boton busqueda para limpiar la busqueda y traer todos los cursos nuevamente
  limpiarBusqueda() {
    /*  this.cursos = this._cursosService.getCursos();
    this.banderaBusqueda = false;
    this.buscador = '';
    this.tecnologia = '';*/
  }

  //para obtener los temas y las tecnolgias
  public obtenerValorPorPosicion(obj: any, posicion: number): any {
    return Object.keys(obj)[posicion];
  }
}
