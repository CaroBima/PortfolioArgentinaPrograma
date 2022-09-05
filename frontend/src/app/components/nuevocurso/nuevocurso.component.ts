import { Component, OnInit } from '@angular/core';
import { Curso } from 'src/app/models/Curso';
import { ICursoInterface } from 'src/app/models/CursoInterface';
import { TecnologiasService } from 'src/app/services/tecnologias.service';
import { ITecnologia } from '../../models/Tecnologia';

@Component({
  selector: 'app-nuevocurso',
  templateUrl: './nuevocurso.component.html',
  styleUrls: ['./nuevocurso.component.css'],
})
export class NuevocursoComponent implements OnInit {
  public tecnologiasArray: ITecnologia[] = [];
  public curso: Curso;
  /*  public tituloCurso: String;
  public nombreCurso: String;
  public institucion: string;
  public descripcion: string;
  public linkImg: string;
  public duracionCurso: string;
  public linkCurso: string;
  public listaTemas: string[];
  public listaTecnologias: string[];*/

  constructor(private _tecnologiasService: TecnologiasService) {
    this.curso = new Curso();
    /*this.tituloCurso = '';
    this.nombreCurso = '';
    this.institucion = '';
    this.descripcion = '';
    this.linkImg = '';
    this.duracionCurso = '';
    this.linkCurso = '';
    this.listaTemas = [];
    this.listaTecnologias = [];*/
  }

  ngOnInit(): void {
    this.traerTecnologias();
    console.log(this.tecnologiasArray);
  }

  public traerTecnologias() {
    this._tecnologiasService.getTecnologias().subscribe((respuesta) => {
      respuesta.forEach((resp) => {
        this.tecnologiasArray.push(resp);
      });
      return respuesta;
    });
  }

  public limpiarTecnologiasArray() {
    this.tecnologiasArray.length = 0;
    this.traerTecnologias();
  }

  public limpiarTemas() {}

  //para obtener los temas y las tecnolgias
  public obtenerValorPorPosicion(obj: any, posicion: number): any {
    return Object.keys(obj)[posicion];
  }
}
