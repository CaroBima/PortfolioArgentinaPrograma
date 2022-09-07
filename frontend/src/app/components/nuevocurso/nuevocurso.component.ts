import { Component, Input, OnInit } from '@angular/core';
import { Curso } from 'src/app/models/Curso';
import { ICursoInterface } from 'src/app/models/CursoInterface';
import { TecnologiasService } from 'src/app/services/tecnologias.service';
import { Tecnologia } from '../../models/Tecnologia';
import { Tema } from '../../models/Tema';

@Component({
  selector: 'app-nuevocurso',
  templateUrl: './nuevocurso.component.html',
  styleUrls: ['./nuevocurso.component.css'],
})
export class NuevocursoComponent implements OnInit {
  public tecnologiasArray: Tecnologia[] = [];
  public temaArray: Tema[] = [];
  public curso: Curso;

  public temasIn: any;

  constructor(private _tecnologiasService: TecnologiasService) {
    this.curso = new Curso();
    this.temasIn = '';
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

  agregarTema(tema: string) {
    let agregarTema = new Tema();
    agregarTema.tema = tema;

    this.temaArray.push(agregarTema);
    this.temasIn = '';
    console.log(this.temaArray);
  }
}
