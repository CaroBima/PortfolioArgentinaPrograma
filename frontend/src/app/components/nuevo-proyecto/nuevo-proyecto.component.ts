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
  public previsualizacion: string = ''; //para previsualizar la imagen principal del proyecto
  public vectorPrevisualizacion!: string[]; //para la previsualización de las imagenes del proyecto
  public file!: File; // Variable para el archivo de imagen
  public proyecto!: Proyecto;

  constructor(
    private sanitizer: DomSanitizer,
    private subirArchivosService: SubirArchivosService
  ) {
    this.proyecto = new Proyecto();
  }

  ngOnInit(): void {}

  guardarProyecto(
    nombreProyecto: string,
    descripcionCorta: string,
    linkRepo: string,
    urlDeploy: string,
    descrAmplia: string
  ) {
    this.proyecto.nombre = nombreProyecto;
    this.proyecto.descrCorta = descripcionCorta;
    this.proyecto.linkRepo = linkRepo;
    this.proyecto.urlDeploy = urlDeploy;
    this.proyecto.descrAmplia = descrAmplia;
    this.proyecto.imgPrincipal = this.previsualizacion;
    //this.proyecto.imagenes = this.vectorPrevisualizacion;

    console.log(this.proyecto);
  }

  agregarImagen() {}

  //------------------------------------------ Carga de img ----------------------------------------------------
  // Al seleccionar la imagen a cargar
  onChange(event: any) {
    this.file = event.target.files[0];
    this.extraerBase64(this.file).then((imagen: any) => {
      //this.previsualizacion = imagen.base;
      this.proyecto.imagenes?.push(imagen.base);
    });
  }

  //para cargar el vector de imagenes
  onChangeVector(event: any) {
    this.file = event.target.files[0];
    this.extraerBase64(this.file).then((imagen: any) => {
      this.vectorPrevisualizacion.push = imagen.base; //agrega la imagen al vector de imagenes
      console.log(this.vectorPrevisualizacion);
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
