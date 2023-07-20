import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { API_URL } from '../configuracion';
import { Usuario } from '../models/Usuario';

const urlConst = `${API_URL}`;


@Injectable({
    providedIn: 'root',
  })


export class LoginService  {
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

 
      
  public sendLoginData(usuario : Usuario){
    let endpoint = this.url + '/login';
    console.log('llega al servicio' + endpoint );
    this.http.post(endpoint, usuario, this.httpOptions).subscribe();
  }
    
 
}  