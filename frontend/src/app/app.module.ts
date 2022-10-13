import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AngularFireModule } from '@angular/fire/compat';
import { AngularFirestoreModule } from '@angular/fire/compat/firestore';
import { environment } from '../environments/environment';

//rutas
import { AppRoutingModule } from './app-routing.module';

//componentes
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { ContactoComponent } from './components/contacto/contacto.component';
import { AplicacionesComponent } from './components/aplicaciones/aplicaciones.component';
import { CursosComponent } from './components/cursos/cursos.component';
import { AplicacionComponent } from './components/aplicacion/aplicacion.component';
import { HttpClientModule } from '@angular/common/http';
import { NuevocursoComponent } from './components/nuevocurso/nuevocurso.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    FooterComponent,
    ContactoComponent,
    AplicacionesComponent,
    CursosComponent,
    AplicacionComponent,
    NuevocursoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFirestoreModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
