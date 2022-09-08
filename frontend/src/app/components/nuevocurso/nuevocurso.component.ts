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
  public tecnologiasBDArray: Tecnologia[] = []; //para traer las tecnologias almacenadas en la bbdd
  public tecnologiasNvoCurso: Tecnologia[] = []; //para guardar y mostras las tecnologias que se carguen en el nvo curso
  public temaArrayNvoCurso: Tema[] = []; //para guardar los temas agregados en el nuevo curso
  public curso: Curso;

  public temasIn: any;

  constructor(private _tecnologiasService: TecnologiasService) {
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
    this.temaArrayNvoCurso.push(agregarTema);
    this.temasIn = '';
  }

  //permite agregar una tecnologia al array de tecnologias que sera guardado
  //falta validar que no se ingrese dos veces la misma tecnologia
  agregarTecnologia(tecnologia: string) {
    let agregarTecno = new Tecnologia();
    let banderaTecno: boolean = false;
    agregarTecno.nombreTecnologia = tecnologia;

    //si hay algo en el array lo recorro para ver si ya se ingreso previamente la tecno, para que no se pueda guardar dos veces la misma
    if (this.tecnologiasNvoCurso.length > 0) {
      for (let tecno of this.tecnologiasNvoCurso) {
        if (tecno.nombreTecnologia === agregarTecno.nombreTecnologia) {
          banderaTecno = true; //si la tecnología ya está en el array guardo true
        }
      }
    }

    //si la tecnologia no esta en el array la agrego
    if (banderaTecno === false) {
      this.tecnologiasNvoCurso.push(agregarTecno);
    }
  }

  /* metodo para mostrar la previsualizacion del curos
public previsualizarCurso() {
      if (tecno.includes(tecnologia)) {
        cursosArray.push(curso);
      }
    }
    return cursosArray;
  }
} */
}
