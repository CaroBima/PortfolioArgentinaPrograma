package portfolio.portfolioBack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idImagen;
    
    @Column(unique=true)
    private String urlImagen;

   
    
    
    
}
