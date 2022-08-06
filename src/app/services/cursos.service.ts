import { Injectable } from '@angular/core';
import { ICursoInterface } from '../models/CursoInterface';

@Injectable({
  providedIn: 'root',
})
export class CursosService {
  private cursos: ICursoInterface[] = [
    {
      titulo: 'Programador web full-stack junior',
      nombre: '#YoProgramo - Argentina Programa',
      institucion:
        'Ministerio de Desarrollo Productivo de la Nación y la Cámara Empresarial de Software y Servicios Informáticos (CESSI)',
      descripcion: 'Segunda etapa del Plan Argentina Programa.',
      img: '../../../assets/img/certificados/yoprogramo.jpg',
      temas:
        'Introducción al desarrollo web, Front End estático, Front End - Desarrollo Web Dinámico, Bases de datos, POO - Buenas prácticas de programación, Java EE, Java Spring boot, DevOps',
      tecnologias:
        'Html, Css, Bootstrap, Javascript, Typescript, Angular, Bases de datos, POO, Java EE, Spring Boot. API, API Rest',
      duracion: '250 hs',
      link: 'https://www.argentina.gob.ar/produccion/argentina-programa/segunda-etapa',
    },
    {
      titulo: 'Programador web Full Stack con Java',
      nombre: 'Codo a Codo',
      institucion: 'Agencia de Aprendizaje a lo largo de vida',
      descripcion:
        'Curso organizado por el Gobierno de la Ciudad de Buenos Aires',
      img: '../../../assets/img/certificados/codoacodo.jpg',
      temas:
        'Html, Css, Boostrap, Js, Git, Scrum, Arquitectura, Bases de datos, Vue, Java, Ajax, Spring',
      tecnologias:
        'Html, Css, Bootstrap, Javascript, GIT, Bases de datos, POO, Java, MySql',
      duracion: '198 hs',
      link: 'https://aulasvirtuales.bue.edu.ar/',
    },
    {
      titulo: 'Programador web Full Stack Java con perfil Junior',
      nombre: 'Programador web Full Stack con Java',
      institucion: 'Polo Tic Misiones',
      descripcion: 'Curso organizado por el Polo Tic Misiones',
      img: '../../../assets/img/certificados/Polo.jpg',
      temas: '',
      tecnologias:
        'Html, Css, Bootstrap, Javascript, Java, Jpa, Jsp, Servlets, Mysql',
      duracion: '100 hs',
      link: 'https://es-la.facebook.com/poloticmisiones',
    },
    {
      titulo: 'Desarrollo de APIs en Java con SpringBoot',
      nombre: '',
      institucion: 'Todo Code Academy',
      descripcion: 'Curso introductorio a la programación.',
      img: '../../../assets/img/certificados/certificadoTodoCode.jpg',
      temas:
        'Arquitectura Cliente-Servidor, Protocolo HTTP: métodos GET, POST, DELETE, PUT, Librerías Vs. Frameworks, Introducción a Maven, Spring Vs Spring Boot, Patrón MVC, APIs Rest, JSON, Postman, Patrón DTO, Arquitectura Multicapas, Inversión de Control, Inyección de dependencias, Motor JPA: Hibernate',
      tecnologias: 'Java, JPA: Hibernate, Postman, Json,  API, API Rest',
      duracion: '120 hs',
      link: 'https://todocodeacademy.com/course/desarrollo-de-apis-con-spring-boot/',
    },
    {
      titulo: '#SeProgramar - Argentina Programa',
      nombre: '',
      institucion:
        'Ministerio de Desarrollo Productivo de la Nación y la Cámara Empresarial de Software y Servicios Informáticos (CESSI)',
      descripcion: '',
      img: '../../../assets/img/certificados/seprogramar.jpg',
      temas:
        'Fundamentos de la programación, Programación imperativa, Programación Orientada a Objetos',
      tecnologias: 'Gobstones, Javascript, POO, Ruby',
      duracion: '60 hs',
      link: 'https://www.argentina.gob.ar/produccion/argentina-programa/primera-etapa',
    },
    {
      titulo: 'Programación Ionic - Android',
      nombre: '',
      institucion:
        'Subsecretaría de Promoción de Empleo de la Municipalidad de Córdoba - UTN FRC',
      descripcion: '',
      img: '../../../assets/img/certificados/MuniIonic.jpg',
      temas:
        'Fundamentos de la programación, Programación imperativa, Programación Orientada a Objetos',
      tecnologias: 'Html, Css, Javascript, Ionic',
      duracion: '',
      link: 'https://empleo.cordoba.gob.ar/services/formacion-para-el-empleo/',
    },
    {
      titulo: 'Habilidades Blandas',
      nombre: '',
      institucion: 'Accenture - Codo a Codo ',
      descripcion: '',
      img: '../../../assets/img/certificados/AccentureHabBlandas.jpg',
      temas:
        'Autoconfianza: Seguridad en si mismo (Avanzado y Master), Autoconocimiento (Avanzado y Master - Comunicación: Expresión escrita (Avanzado y Máster), Comprensión escrita (Avanzado y Máster)',
      tecnologias: '',
      duracion: '8 hs',
      link: '',
    },
    {
      titulo: 'Metodologías Ágiles y SCRUM - Introducción',
      nombre: '',
      institucion: 'Vates',
      descripcion: '',
      img: '../../../assets/img/certificados/metAgilesYScrumVates01.jpg',
      temas: 'Antecedentes, Agilidad, SCRUM, ¿Por qué Scrum?',
      tecnologias: 'Scrum',
      duracion: '',
      link: '',
    },
    {
      titulo: 'Implementación de SCRUM',
      nombre: '',
      institucion: 'Vates',
      descripcion: '',
      img: '../../../assets/img/certificados/metAgilesYScrumVates02.jpg',
      temas: 'Roles Scrum, Elementos, Reuniones, Conceptos Útiles',
      tecnologias: 'Scrum',
      duracion: '',
      link: '',
    },
    {
      titulo: 'Proceso de Desarrollo ISO',
      nombre: '',
      institucion: 'Vates',
      descripcion: '',
      img: '../../../assets/img/certificados/ProcesoDesarrolloISO.jpg',
      temas: 'Introducción, Workflows de Soporte, Workflows de Ejecución',
      tecnologias: '',
      duracion: '',
      link: '',
    },
  ];
  constructor() {}

  //devuelve todos los cursos
  public getCursos() {
    return this.cursos;
  }

  //permite buscar un curso de acuerdo a la tecnologia buscada en el searchbar
  public buscadorCurso(tecnologia: string) {
    let cursosArray: ICursoInterface[] = [];
    tecnologia = tecnologia.toLowerCase();

    for (let curso of this.cursos) {
      let tecno = curso.tecnologias.toLowerCase();

      if (tecno.includes(tecnologia)) {
        cursosArray.push(curso);
      }
    }
    return cursosArray;
  }
}
