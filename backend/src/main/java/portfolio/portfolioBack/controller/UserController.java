package portfolio.portfolioBack.controller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import portfolio.portfolioBack.dto.UsuarioDto;
import portfolio.portfolioBack.model.Usuario;

@RestController
public class UserController {

    @PostMapping("user")
    public UsuarioDto login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        String token = getJWTToken(username);
        UsuarioDto user = new UsuarioDto();
        user.setNombreUsuario(username);
        user.setToken(token);
        return user;

    }

    private String getJWTToken(String username) {
        String secretKey = "AnastasiaPortfolio";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("PortfolioCB")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}


/*
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
    
}*/
