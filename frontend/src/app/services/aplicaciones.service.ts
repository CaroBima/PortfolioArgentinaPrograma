import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Aplicacion } from '../models/aplicacion';

@Injectable({
  providedIn: 'root',
})
export class AplicacionesService {
  private url;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, PUT, POST, DELETE, HEAD, OPTIONS',
    }),
  };
  private aplicaciones: Aplicacion[] = [];

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080';
  }

  //devuelve todas las aplicaciones
  public getAplicaciones(): Observable<Aplicacion[]> {
    let endpoint = this.url + '/buscarproyectos';
    return this.http.get<Aplicacion[]>(endpoint, this.httpOptions);
  }

  //devuelve una aplicacion puntual por el id, se usa para mostrar el detalle de la app
  public getAplicacion(id: number) {
    return this.aplicaciones[id];
  }
}
