package portfolio.portfolioBack.model;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Usuario {
    private long idUsuario;
    private String nombreUsuario;
    private String contrasenia;
    private String email;

    public Usuario() {
    }

    public Usuario(long idUsuario, String nombreUsuario, String contrasenia, String email) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.email = email;
    }

     
}
