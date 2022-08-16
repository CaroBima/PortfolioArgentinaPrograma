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
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idImagen;
    private String urlImagen;

    public Imagen() {
    }

    public Imagen(long idImagen, String urlImagen) {
        this.idImagen = idImagen;
        this.urlImagen = urlImagen;
    }
    
    
}
