import { LEADING_TRIVIA_CHARS } from '@angular/compiler/src/render3/view/template';
import { Component, OnInit } from '@angular/core';
import { ICursoInterface } from 'src/app/models/CursoInterface';
import { CursosService } from 'src/app/services/cursos.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
})
export class CursosComponent implements OnInit {
  cursos: ICursoInterface[] = [];
  constructor(private _cursosService: CursosService) {}

  ngOnInit(): void {
    this.cursos = this._cursosService.getCursos();
  }

  public buscarTecnologia(tecnologia: string) {
    this.cursos = this._cursosService.buscadorCurso(tecnologia);
  }
}
