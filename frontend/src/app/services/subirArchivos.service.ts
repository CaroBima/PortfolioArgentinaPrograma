import { HttpClient } from '@angular/common/http';
import { Injectable, Sanitizer } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SubirArchivosService {
  // API url
  baseApiUrl = 'http://localhost:4200/assets/img/certificados'; //directorio donde se va a cargar la imagen

  constructor(private http: HttpClient, private sanitizer: DomSanitizer) {
    this.sanitizer = sanitizer;
  }

  subirImagen(file: File): Observable<any> {
    //crea el formData
    const formData = new FormData();

    // Store form name as "file" with file data
    formData.append('file', file, file.name);

    // Make http post request over api
    // with formData as req
    return this.http.post(this.baseApiUrl, formData);
  }
}
