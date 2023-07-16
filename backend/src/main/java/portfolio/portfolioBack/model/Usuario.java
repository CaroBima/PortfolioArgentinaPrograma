package portfolio.portfolioBack.model;


/*
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;*/
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


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

    @ManyToOne
    private RolUsuario rolUsuario;
    

    public Usuario() {
    }

    public Usuario(long idUsuario, String nombreUsuario, String contrasenia, String email, RolUsuario rolUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.email = email;
        this.rolUsuario = rolUsuario;
    }

     
}
