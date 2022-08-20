
package portfolio.portfolioBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.portfolioBack.model.Usuario;
import portfolio.portfolioBack.service.IUsuarioService;

@RestController
public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;
    
    @PostMapping("/login")
    private boolean loginUsuario(@RequestBody Usuario usuario){
       return usuarioService.logueoUsuario(usuario);
    }
}
