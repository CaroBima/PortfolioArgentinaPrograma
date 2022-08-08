import { Injectable } from '@angular/core';
import { Aplicacion } from '../models/aplicacion';

@Injectable({
  providedIn: 'root',
})
export class AplicacionesService {
  private aplicaciones: Aplicacion[] = [
    {
      nombre: 'Gestión Hotelera',
      descripcion:
        'Aplicación web realizada con Java, utilizando Servlets, JSP y JPA. Base de datos hecha con MySql. Para el front se utilizó un template adaptado, con bootstrap. Validaciones realizadas con JS.',
      imgPrev: '../../../assets/img/Hotel index.jpg',
      descripAmplia:
        'Aplicación web que permite gestionar las reservas de un hotel. Permite además añadir las habitaciones o modificarlas y lo mismo con los datos de los empleados y su puesto.',
      url: '',
      repo: 'https://github.com/CaroBima/ReservaHotel',
      img1: '../../../assets/img/menulogueohotel.jpg',
      img2: '../../../assets/img/Hotel-Alta-Empleado.png',
      img3: '../../../assets/img/Hotel-Guardado-de-datos-empleado.png',
      github: 'https://github.com/CaroBima/ReservaHotel',
    },
    {
      nombre: 'Beer Stock',
      descripcion:
        'Aplicación web para la gestión de stock de una cervezería artesanal. Realizada con Java usando Servlets, JPA, JSP, con MySql. Utilizando además bootstrap y js.',
      imgPrev: '../../../assets/img/beerStock.gif',
      descripAmplia:
        'Trabajo realizado para el módulo de programación de la Tecnicatura en Desarrollo Web y Aplicaciones Digitales dictada por el ISPC. Permite el control de stock de materia primas y de producción de cervezas artesanales. Permite guardar las recetas y datos de los proveedores de materias primas. Aún se encuentra en desarrollo. Realizado junto a Alejandra Battistoni, Domingo Gentilini, Jessica Araya y María de los Angeles Moyano',
      url: '',
      repo: '',
      img1: '',
      img2: '',
      img3: '',
      github: 'https://github.com/PPROF2-2022ProgWeb/g20-aula1-beerstock-g20',
    },
    {
      nombre: 'Sitio web Codo a Codo',
      descripcion:
        'Sitio realizado con bootstrap y Js. Hecho para el curso de Java Full Stack de Codo a Codo',
      imgPrev: '../../../assets/img/codoacodo01.png',
      descripAmplia:
        'Sitio web realizado como trabajo práctico del curso, copiando una imagen jpg dada por los docentes. Permite además calcular, desde el link de Comprar tickets, el costo de los tickets de acuerdo a la cantidad y categoría ingresados por el usuario',
      url: 'https://codoacodotpintegrador.netlify.app/',
      repo: '../../../assets/img/codoacodo02.png',
      img1: '../../../assets/img/codoacodo03.png',
      img2: '../../../assets/img/codoacodo04.png',
      img3: '',
      github:
        'https://github.com/CaroBima/CodoACodo/tree/main/04%20y%2005%20-%20Tp%20Integrador',
    },
    {
      nombre: 'Task Reminder',
      descripcion:
        'Una muy sencilla aplicacion web realizada con Angular. Permite agendar tareas.',
      imgPrev: '../../../assets/img/Reminder.jpg',
      descripAmplia:
        'Aplicación web realizada en angular, con la persistencia en un archivo json. Permite agregar tareas y eliminarlas. Además permite marcarlas como importantes. Realizado como trabajo práctico de la segunda parte  del Argentina Programa (#YoProgramo, 2da Edición)',
      url: '',
      repo: '',
      img1: '',
      img2: '',
      img3: '',
      github: 'https://github.com/CaroBima/TaskReminder',
    },
    {
      nombre: 'Mini Agenda',
      descripcion:
        'Aplicación de escritorio realizada con Java, utilizando Swing.',
      imgPrev: '../../../assets/img/miniagenda.gif',
      descripAmplia:
        'Aplicación de escritorio realizada en java, utilizando Swing. Permite guardar y recuperar los datos de contactos, utilizando para la persistencia un archivo txt',
      url: '',
      repo: '',
      img1: '',
      img2: '',
      img3: '',
      github: 'https://github.com/CaroBima/MiniAgenda',
    },
    {
      nombre: 'Cálculo de área y perímetro',
      descripcion:
        'Aplicación de escritorio realizada con Java. Permite calcular el área y el perímetro de la figura geométrica seleccionada.',
      imgPrev: '../../../assets/img/Cálculo de área y perímetro.jpg',
      descripAmplia:
        'Aplicación de escritorio realizada en java, utilizando Swing. Permite calcular el área y el perímetro de la figura geométrica que seleccione el usuario. Una vez que selecciona el usuario permite el ingreso de los valores necesarios para realizar dicho cálculo y seleccionar si se quiere calcular el área o el perímetro.',
      url: '',
      repo: '',
      img1: '../../../assets/img/areacuadrado.jpg',
      img2: '../../../assets/img/calculoValidacion.jpg',
      img3: '../../../assets/img/perimetroTriangulo.jpg',
      github: 'https://github.com/CaroBima/FiguraGeometrica',
    },
  ];

  constructor() {}

  //devuelve todas las aplicaciones
  public getAplicaciones() {
    return this.aplicaciones;
  }

  //devuelve una aplicacion puntual por el id, se usa para mostrar el detalle de la app
  public getAplicacion(id: number) {
    return this.aplicaciones[id];
  }
}
