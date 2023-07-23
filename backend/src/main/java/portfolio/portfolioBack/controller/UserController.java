package portfolio.portfolioBack.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import portfolio.portfolioBack.dto.UsuarioLoginDto;
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
    public ResponseEntity<UsuarioLoginDto> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        UsuarioLoginDto userLoginDto = new UsuarioLoginDto();
        Usuario usuario = new Usuario();

        usuario.setNombreUsuario(username);
        usuario.setContrasenia(pwd);
        try {
            if (usuarioService.logueoUsuario(usuario)) {
                String token = securityConfig.getJWTToken(username);
                userLoginDto.setNombreUsuario(username);
                userLoginDto.setToken(token);

            }

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en login");
        }

        return ResponseEntity.ok(userLoginDto); //ver de retornar error cuando no este ok el login

    }

    @PostMapping("/register") ////FALTA VALIDAR QUE EL NOMBRE DE USUARIO NO ESTE YA EN USO
    public ResponseEntity registerUser(@RequestParam("user") String username, @RequestParam("password") String pwd){
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(username);
        usuario.setContrasenia(pwd);
        int resultadoGuardado = 0;


        try {
            resultadoGuardado = usuarioService.crearUsuario(usuario);
        }catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al guardar usuario");
            }

        if(resultadoGuardado == 1){
            return ResponseEntity.status(HttpStatus.CREATED).body("El usuario ha sido creado exitosamente.");
        }else if (resultadoGuardado == 2){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre de usuario ya se encuentra en uso.");
        }else
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario no pudo ser creado. Intente nuevamente más tarde o contacte con un administrador.");
    }

}

