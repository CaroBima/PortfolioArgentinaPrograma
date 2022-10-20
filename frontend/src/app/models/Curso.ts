import { Tecnologia } from './Tecnologia';
import { Tema } from './Tema';

export class Curso {
  tituloCurso?: String;
  nombreCurso?: String;
  institucion?: string;
  descripcion?: string;
  //linkImg?: string;
  duracionCurso?: string;
  imagen?: string;
  listaTemas?: Tema[];
  listaTecnologias?: Tecnologia[];

  constructor() {}

  /*  constructor(
    tituloCurso: String,
    nombreCurso: String,
    institucion: string,
    descripcion: string,
    linkImg: string,
    duracionCurso: string,
    linkCurso: string,
    listaTemas: string[],
    listaTecnologias: string[]
  ) {
    this.tituloCurso = tituloCurso;
    this.nombreCurso = nombreCurso;
    this.institucion = institucion;
    this.descripcion = descripcion;
    this.linkImg = linkImg;
    this.duracionCurso = duracionCurso;
    this.linkCurso = linkCurso;
    this.listaTemas = listaTemas;
    this.listaTecnologias = listaTecnologias;
  }*/
}
