import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Curso } from 'src/app/models/Curso';
import { ICursoInterface } from 'src/app/models/CursoInterface';
import { SubirArchivosService } from 'src/app/services/subirArchivos.service';
import { TecnologiasService } from 'src/app/services/tecnologias.service';
import { Tecnologia } from '../../models/Tecnologia';
import { Tema } from '../../models/Tema';

@Component({
  selector: 'app-nuevocurso',
  templateUrl: './nuevocurso.component.html',
  styleUrls: ['./nuevocurso.component.css'],
})
export class NuevocursoComponent implements OnInit {
  public tecnologiasBDArray: Tecnologia[] = []; //para traer las tecnologias almacenadas en la bbdd
  public tecnologiasNvoCurso: Tecnologia[] = []; //para guardar y mostras las tecnologias que se carguen en el nvo curso
  public temaArrayNvoCurso: Tema[] = []; //para guardar los temas agregados en el nuevo curso
  public curso: Curso;
  public shortLink: string = '';
  public loading: boolean = false; // Flag variable
  public file!: File; // Variable to store file
  public temasIn: any;
  public previsualizacion: string = '';

  constructor(
    private _tecnologiasService: TecnologiasService,
    private http: HttpClient,
    private subirArchivosService: SubirArchivosService,
    private sanitizer: DomSanitizer
  ) {
    this.curso = new Curso();
    this.temasIn = '';
  }

  ngOnInit(): void {
    this.traerTecnologias();
    console.log(this.tecnologiasBDArray);
  }

  public traerTecnologias() {
    this._tecnologiasService.getTecnologias().subscribe((respuesta) => {
      respuesta.forEach((resp) => {
        this.tecnologiasBDArray.push(resp);
      });
      return respuesta;
    });
  }

  public limpiarTecnologiasArray() {
    this.tecnologiasBDArray.length = 0;
    this.traerTecnologias();
  }

  //para obtener los temas y las tecnolgias
  public obtenerValorPorPosicion(obj: any, posicion: number): any {
    return Object.keys(obj)[posicion];
  }

  //permite agregar un tema al array para el nvo curso
  agregarTema(tema: string) {
    let agregarTema = new Tema();
    agregarTema.tema = tema;
    if (agregarTema.tema.length >= 2) this.temaArrayNvoCurso.push(agregarTema); //valido que se ingresen al menos dos caracteres
    this.temasIn = '';
  }

  //permite agregar una tecnologia al array de tecnologias que sera guardado
  agregarTecnologia(tecnologia: string) {
    let agregarTecno = new Tecnologia();
    let banderaTecno: boolean = false;
    agregarTecno.nombreTecnologia = tecnologia;

    if (this.tecnologiasNvoCurso.length > 0) {
      //si hay algo en el array lo recorro para ver si ya se ingreso previamente la tecno, para que no se pueda guardar dos veces la misma
      for (let tecno of this.tecnologiasNvoCurso) {
        if (tecno.nombreTecnologia === agregarTecno.nombreTecnologia) {
          banderaTecno = true; //si la tecnología ya está en el array guardo true
        }
      }
    }

    if (banderaTecno === false) {
      //si la tecnologia no esta en el array la agrego
      this.tecnologiasNvoCurso.push(agregarTecno);
    }
  }

  // On file Select
  onChange(event: any) {
    this.file = event.target.files[0];
    this.extraerBase64(this.file).then((imagen: any) => {
      this.previsualizacion = imagen.base;
      console.log(imagen);
    });
    console.log(this.file);
  }

  // OnClick of button Upload
  onUpload() {
    //this.loading = !this.loading;
    //console.log(this.file);
    console.log('OnUpload');
    this.subirArchivosService.subirImagen(
      this.file
    ); /*.subscribe((event: any) => {
      if (typeof event === 'object') {
        // Short link via api response
        this.shortLink = event.link;

        this.loading = false; // Flag variable
      }
    });*/
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
