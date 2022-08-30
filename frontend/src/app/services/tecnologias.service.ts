import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ITecnologia } from '../models/Tecnologia';

@Injectable({
  providedIn: 'root',
})
export class TecnologiasService {
  private url;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, PUT, POST, DELETE, HEAD, OPTIONS',
    }),
  };

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080';
  }

  //devuelve todos los cursos almacenados en la bbdd
  public getTecnologias(): Observable<ITecnologia[]> {
    let endpoint = this.url + '/buscarTecnologias';
    return this.http.get<ITecnologia[]>(endpoint, this.httpOptions);
  }
}
