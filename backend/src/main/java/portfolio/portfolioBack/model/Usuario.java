package portfolio.portfolioBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Usuario {
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
