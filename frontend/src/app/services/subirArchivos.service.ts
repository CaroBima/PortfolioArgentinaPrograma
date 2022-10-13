import { HttpClient } from '@angular/common/http';
import { Injectable, Sanitizer } from '@angular/core';
import { AngularFirestoreModule } from '@angular/fire/compat/firestore';
import { DomSanitizer } from '@angular/platform-browser';
import { getStorage, ref, uploadString } from 'firebase/storage';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SubirArchivosService {
  // API url
  baseApiUrl = 'http://localhost:4200/assets/img/certificados'; //directorio donde se va a cargar la imagen
  public previsualizacion: string = '';

  constructor(
    private http: HttpClient,
    private storage: AngularFirestoreModule,
    private sanitizer: DomSanitizer
  ) {}

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

    /*
    //firebase
    //const filePath = file.name;
    //const fileRef = this.storage.ref(filePath);
    const storage = getStorage();
    const imgRef = ref(storage, file.name);

    // Data URL string
    this.extraerBase64(file).then((imagen: any) => {
      this.previsualizacion = imagen.base;
      return imagen.base;
      console.log(imagen);
    });

    uploadString(imgRef, this.previsualizacion, 'data_url').then((snapshot) => {
      console.log('Uploaded a data_url string!');
    });*/
  }
}
