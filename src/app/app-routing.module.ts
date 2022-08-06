import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { AplicacionComponent } from './components/aplicacion/aplicacion.component';
import { AplicacionesComponent } from './components/aplicaciones/aplicaciones.component';
import { CursosComponent } from './components/cursos/cursos.component';
import { HomeComponent } from './components/home/home.component';

const ROUTES: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'aplicaciones', component: AplicacionesComponent },
  { path: 'aplicacion/:id', component: AplicacionComponent },
  { path: 'cursos', component: CursosComponent },
  { path: '**', pathMatch: 'full', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(ROUTES)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
