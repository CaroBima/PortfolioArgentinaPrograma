import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpClientModule,
  HttpHeaders,
} from '@angular/common/http';
import { map } from 'rxjs/operators';

import { ICursoInterface } from '../models/CursoInterface';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root',
})
export class CursosService {
  private cursos: ICursoInterface[] = [];
  private buscarcursosUrl;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, PUT, POST, DELETE, HEAD, OPTIONS',
    }),
  };

  constructor(private http: HttpClient) {
    this.buscarcursosUrl = 'http://localhost:8080/buscarcursos';
  }

  //devuelve todos los cursos almacenados en la bbdd
  public getCursos(): Observable<ICursoInterface[]> {
    return this.http.get<ICursoInterface[]>(
      this.buscarcursosUrl,
      this.httpOptions
    );
  }

  //permite buscar un curso de acuerdo a la tecnologia buscada en el searchbar
  /*public buscadorCurso(tecnologia: string) {
    let cursosArray: ICursoInterface[] = [];
    tecnologia = tecnologia.toLowerCase();

    for (let curso of this.cursos) {
      let tecno = curso.tecnologias.toLowerCase();

      if (tecno.includes(tecnologia)) {
        cursosArray.push(curso);
      }
    }
    return cursosArray;
  }*/
}
