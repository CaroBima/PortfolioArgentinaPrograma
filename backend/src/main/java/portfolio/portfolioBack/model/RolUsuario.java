package portfolio.portfolioBack.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idRolxUsuario;

    private String nombreRol;
}
