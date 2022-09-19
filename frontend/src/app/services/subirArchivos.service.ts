import { HttpClient } from '@angular/common/http';
import { Injectable, Sanitizer } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SubirArchivosService {
  // API url
  baseApiUrl = 'http://localhost:4200/assets/img/certificados'; //directorio donde se va a cargar la imagen

  constructor(private http: HttpClient) {}

  subirImagen(file: File): any {
    //crea el formData
    try {
      const formData = new FormData();

      // Store form name as "file" with file data
      formData.append('file', file, file.name);

      // Make http post request over api
      // with formData as req
      return this.http.post(this.baseApiUrl, formData);
    } catch (e) {
      //return null;
    }
  }
}
