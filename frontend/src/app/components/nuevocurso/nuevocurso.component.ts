import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Curso } from 'src/app/models/Curso';
import { ICursoInterface } from 'src/app/models/CursoInterface';
import { CursosService } from 'src/app/services/cursos.service';
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
  public curso!: Curso;
  public shortLink: string = '';
  public loading: boolean = false; // Flag variable
  public file!: File; // Variable to store file
  public temasIn: any;
  public tecnologiasIn: any;
  public previsualizacion: string = '';

  constructor(
    private _tecnologiasService: TecnologiasService,
    private http: HttpClient,
    private subirArchivosService: SubirArchivosService,
    private cursoService: CursosService,
    private sanitizer: DomSanitizer
  ) {
    this.curso = new Curso();
    this.temasIn = '';
    this.curso.listaTemas = [];
    this.curso.listaTecnologias = [];
  }

  ngOnInit(): void {
    //this.traerTecnologias();
  }

  //para obtener los temas y las tecnolgias
  public obtenerValorPorPosicion(obj: any, posicion: number): any {
    return Object.keys(obj)[posicion];
  }

  //permite agregar un tema al array para el nvo curso
  agregarTema(tema: string) {
    let agregarTema = new Tema();
    agregarTema.nombreTema = tema;
    if (agregarTema.nombreTema.length >= 2)
      this.temaArrayNvoCurso.push(agregarTema); //valido que se ingresen al menos dos caracteres
    this.temasIn = '';
  }

  //Permite agredar una tecnologia al array de tecnologias
  agregarTecnologia(tecno: string) {
    let agregarTecno = new Tecnologia();
    agregarTecno.nombreTecnologia = tecno;
    if (agregarTecno.nombreTecnologia.length >= 2)
      this.tecnologiasNvoCurso.push(agregarTecno);
    this.tecnologiasIn = '';
  }

  // Al seleccionar la imagen a cargar
  onChange(event: any) {
    this.file = event.target.files[0];
    this.extraerBase64(this.file).then((imagen: any) => {
      this.previsualizacion = imagen.base;
    });
  }

  onUpload() {
    this.subirArchivosService.subirImagen(this.file);
  }

  //método para el guardado del curso
  guardarNuevoCurso(
    titulo: string,
    nombreCurso: string,
    institucion: string,
    descripcion: string,
    duracion: string
  ) {
    this.curso.tituloCurso = titulo;
    this.curso.nombreCurso = nombreCurso;
    this.curso.institucion = institucion;
    this.curso.descripcion = descripcion;
    this.curso.duracionCurso = duracion;
    this.curso.imagen = this.previsualizacion;

    for (let tema of this.temaArrayNvoCurso) {
      this.curso.listaTemas!.push(tema);
    }

    for (let tecnologia of this.tecnologiasNvoCurso) {
      this.curso.listaTecnologias!.push(tecnologia);
    }
    this.cursoService.guardarCurso(this.curso);
    this.curso.tituloCurso = '';
    this.curso.nombreCurso = '';
    this.curso.institucion = '';
    this.curso.descripcion = '';
    this.curso.duracionCurso = '';
    this.curso.imagen = '';
    this.temasIn = '';
    this.tecnologiasIn = '';
    this.curso.listaTecnologias = [];
    this.curso.listaTemas = [];
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

  /* //METODOS DE TECNOLOGIA CON EL SELECT
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
      console.log(this.tecnologiasNvoCurso);
    }*/
}
