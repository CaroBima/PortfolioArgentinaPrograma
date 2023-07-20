
package portfolio.portfolioBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.portfolioBack.dto.UsuarioDto;
import portfolio.portfolioBack.model.Usuario;
import portfolio.portfolioBack.service.IUsuarioService;


@RestController
public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;
    
    @PostMapping("/login")
    public void loginUsuario(@RequestBody UsuarioDto usuarioDto){
        System.out.println("Llega al back");
        System.out.println(usuarioDto.getNombreUsuario());
        System.out.println(usuarioDto.getContrasenia());

    }
    
}
