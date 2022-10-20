import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ICursoInterface } from 'src/app/models/CursoInterface';
import { CursosService } from 'src/app/services/cursos.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
})
export class CursosComponent implements OnInit {
  public cursos: ICursoInterface[] = [];
  public cursosArray: ICursoInterface[] = [];
  buscador: any;
  banderaBusqueda: boolean;
  tecnologia: string;
  public imagenCurso: string = '';
  constructor(
    private _cursosService: CursosService,
    private sanitizer: DomSanitizer
  ) {
    this.banderaBusqueda = false;
    this.tecnologia = '';
  }

  ngOnInit(): void {
    this.traerCusros();
  }

  public traerCusros() {
    this._cursosService.getCursos().subscribe((respuesta) => {
      respuesta.forEach((x) => {
        this.extraerBase64(x.imagen).then((img: any) => {
          x.imagen = img.base;
        });
        this.cursos.push(x);
      });
      return respuesta;
    });
  }

  //permite traer los cursos de acuerdo al string escrito en el buscador
  public buscarTecnologia(tecnologia: string) {
    this.cursosArray = []; //vacio el array
    this.cursosArray = this.cursos; //lo cargo con el listado de cursos

    this.cursos = []; //vacio el array original de cursos para cargarlo en el for
    for (let curso of this.cursosArray) {
      for (let tecno of curso.listaTecnologias) {
        let nombreTecno = tecno[this.obtenerValorPorPosicion(tecno, 1)];
        nombreTecno = nombreTecno.toLowerCase();
        if (nombreTecno.includes(tecnologia.toLowerCase())) {
          this.cursos.push(curso);
        }
      }
    }

    this.banderaBusqueda = true;
  }

  //metodo del boton busqueda para limpiar la busqueda y traer todos los cursos nuevamente
  limpiarBusqueda() {
    this.cursos.length = 0;
    this.traerCusros(); //vuelve a traer el listado de cursos
    this.banderaBusqueda = false;
    this.buscador = '';
    this.tecnologia = '';
  }

  //para obtener los temas y las tecnolgias
  public obtenerValorPorPosicion(obj: any, posicion: number): any {
    return Object.keys(obj)[posicion];
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
