import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { ICursoInterface } from '../models/CursoInterface';
import { Observable } from 'rxjs/internal/Observable';
import { Curso } from '../models/Curso';
import { API_URL } from '../configuracion';


const urlConst = `${API_URL}`;


@Injectable({
  providedIn: 'root',
})


export class CursosService {

  private cursos: ICursoInterface[] = [];
  private url;

  
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, PUT, POST, DELETE, HEAD, OPTIONS',
    }),
  };

  constructor(private http: HttpClient) {
    this.url = urlConst;
  }

  //devuelve todos los cursos almacenados en la bbdd
  public getCursos(): Observable<ICursoInterface[]> {
    let endpoint = this.url + '/buscarcursos';
    return this.http.get<ICursoInterface[]>(endpoint, this.httpOptions);
  }

  //metodo para realizar el borrado de alguno de los cursos
  public borrarCurso(idCurso: number) {
    let endpoint = this.url + '/borrarcurso?idCurso=' + idCurso;
    this.http.delete(endpoint, this.httpOptions);
  }

  public guardarCurso(nuevoCurso: Curso) {
    let endpoint = this.url + '/nuevocurso';
    this.http.post(endpoint, nuevoCurso, this.httpOptions).subscribe();
  }
}
