package portfolio.portfolioBack.controller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import portfolio.portfolioBack.dto.UsuarioDto;
import portfolio.portfolioBack.model.Usuario;
import portfolio.portfolioBack.security.SecurityConfig;
import portfolio.portfolioBack.service.UsuarioService;

@RestController
public class UserController {

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public UsuarioDto login(@RequestParam("user") String username, @RequestParam("password") String pwd) {


        String token = securityConfig.getJWTToken(username);
        UsuarioDto userDto = new UsuarioDto();
        userDto.setNombreUsuario(username);
        userDto.setToken(token);
        return userDto;

    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestParam("user") String username, @RequestParam("password") String pwd){
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(username);
        usuario.setContrasenia(pwd);

        try {
            usuarioService.crearUsuario(usuario);
        }catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al guardar usuario");
            }

        return ResponseEntity.status(HttpStatus.CREATED).body("El usuario ha sido creado exitosamente.");
    }


}

