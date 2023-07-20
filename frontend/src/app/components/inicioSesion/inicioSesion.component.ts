import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Usuario } from '../../models/Usuario';



@Component({
  selector: 'app-inicioSesion',
  templateUrl: './inicioSesion.component.html',
  styleUrls: ['./inicioSesion.component.css']
})
export class InicioSesionComponent implements OnInit {
  
  public usuario: Usuario;

  constructor(private loginService : LoginService) {
    this.usuario = new Usuario();  

   }
  

  ngOnInit(  ) {
  }

  iniciarSesion(){
    this.usuario.nombreUsuario = 'admin';
    this.usuario.contrasenia = 'password';
    console.log('llega al iniciarSesion');
    this.loginService.sendLoginData(this.usuario);
  }

}
