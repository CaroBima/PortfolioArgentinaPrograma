import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactoComponent } from './components/contacto/contacto.component';
import { AplicacionComponent } from './components/aplicacion/aplicacion.component';
import { AplicacionesComponent } from './components/aplicaciones/aplicaciones.component';
import { CursosComponent } from './components/cursos/cursos.component';
import { HomeComponent } from './components/home/home.component';
import { MiStackComponent } from './components/miStack/miStack.component';
import { InicioSesionComponent } from './components/inicioSesion/inicioSesion.component';
import { NuevocursoComponent } from './components/nuevocurso/nuevocurso.component';
import { NuevoProyectoComponent } from './components/nuevo-proyecto/nuevo-proyecto.component';

const ROUTES: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'contacto', component: ContactoComponent },
  { path: 'aplicaciones', component: AplicacionesComponent },
  { path: 'aplicacion/:app', component: AplicacionComponent },
  { path: 'cursos', component: CursosComponent },
  { path: 'mistack', component: MiStackComponent },
  { path: 'inicioSesion', component: InicioSesionComponent },
  { path: 'nuevocurso', component: NuevocursoComponent },
  { path: 'nuevoproyecto', component: NuevoProyectoComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', pathMatch: 'full', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(ROUTES)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
