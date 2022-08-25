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
  public cursosArray: ICursoInterface[] = [];
  buscador: any;
  banderaBusqueda: boolean;
  tecnologia: string;
  constructor(private _cursosService: CursosService) {
    this.banderaBusqueda = false;
    this.tecnologia = '';
  }

  ngOnInit(): void {
    this.traerCusros();
    console.log(this.cursos);
  }

  public traerCusros() {
    this._cursosService.getCursos().subscribe((respuesta) => {
      respuesta.forEach((x) => {
        this.cursos.push(x);
      });
      return respuesta;
    });
  }
  //permite traer los cursos de acuerdo al string escrito en el buscador
  public buscarTecnologia(tecnologia: string) {
    this.cursosArray = []; //vacio el array
    this.cursosArray = this.cursos; //lo cargo con el listado de cursos

    this.cursos = []; //vacio el array original de cursos para cargarlo en el for
    for (let curso of this.cursosArray) {
      for (let tecno of curso.listaTecnologias) {
        let nombreTecno = tecno[this.obtenerValorPorPosicion(tecno, 1)];
        nombreTecno = nombreTecno.toLowerCase();
        console.log(nombreTecno);
        if (nombreTecno.includes(tecnologia.toLowerCase())) {
          this.cursos.push(curso);
        }
      }
    }
    console.log(this.cursosArray.length);
    this.banderaBusqueda = true; //falta hacer que los muestre
  }

  //metodo del boton busqueda para limpiar la busqueda y traer todos los cursos nuevamente
  limpiarBusqueda() {
    this.cursos.length = 0;
    this.traerCusros(); //vuelve a traer el listado de cursos
    this.banderaBusqueda = false;
    this.buscador = '';
    this.tecnologia = '';
  }

  //para obtener los temas y las tecnolgias
  public obtenerValorPorPosicion(obj: any, posicion: number): any {
    return Object.keys(obj)[posicion];
  }
}
