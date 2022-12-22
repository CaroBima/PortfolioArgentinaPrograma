import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Proyecto } from 'src/app/models/Proyecto';
import { SubirArchivosService } from 'src/app/services/subirArchivos.service';

@Component({
  selector: 'app-nuevo-proyecto',
  templateUrl: './nuevo-proyecto.component.html',
  styleUrls: ['./nuevo-proyecto.component.css'],
})
export class NuevoProyectoComponent implements OnInit {
  public previsualizacion: string = '';
  public file!: File; // Variable to store file
  public proyecto!: Proyecto;

  constructor(
    private sanitizer: DomSanitizer,
    private subirArchivosService: SubirArchivosService
  ) {}

  ngOnInit(): void {}

  //------------------------------------------ Cargado de img ----------------------------------------------------
  // Al seleccionar la imagen a cargar
  onChange(event: any) {
    this.file = event.target.files[0];
    this.extraerBase64(this.file).then((imagen: any) => {
      this.previsualizacion = imagen.base;
    });
  }

  //para cargar el vector de imagenes
  onChangeVector(event: any) {
    this.file = event.target.files[0];
    this.extraerBase64(this.file).then((imagen: any) => {
      this.previsualizacion = imagen.base;
    });
  }

  onUpload() {
    this.subirArchivosService.subirImagen(this.file);
  }

  extraerBase64 = async ($event: any) =>
    new Promise((resolve, reject) => {
      try {
        const unsafeImg = window.URL.createObjectURL($event);
        const image = this.sanitizer.bypassSecurityTrustUrl(unsafeImg);
        const reader = new FileReader();
        reader.readAsDataURL($event);
        reader.onload = () => {
          resolve({
            base: reader.result,
          });
        };
        reader.onerror = (error) => {
          resolve({
            base: null,
          });
        };
      } catch (e) {
        //return null;
      }
    });
}
