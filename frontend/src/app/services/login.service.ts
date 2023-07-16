import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { API_URL } from '../configuracion';

const urlConst = `${API_URL}`;


@Injectable({
    providedIn: 'root',
  })


export class loginService  {
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
    
}  