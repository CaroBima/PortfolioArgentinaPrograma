import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Aplicacion } from '../models/aplicacion';

import { API_URL } from '../configuracion';


const urlConst = `${API_URL}`;

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

  constructor(private http: HttpClient) {
    this.url = urlConst;
    //this.url = 'https://git.heroku.com/sheltered-peak-37372.git';
  }

  //devuelve todas las aplicaciones
  public getAplicaciones(): Observable<Aplicacion[]> {
    let endpoint = this.url + '/buscarproyectos';
    return this.http.get<Aplicacion[]>(endpoint, this.httpOptions);
  }

  //devuelve una aplicacion puntual por el id, se usa para mostrar el detalle de la app
  public getAplicacion(id: number): Observable<Aplicacion> {
    let endpoint = this.url + '/buscarproyecto?idProyecto=' + id;
    return this.http.get<Aplicacion>(endpoint, this.httpOptions);
  }
}
