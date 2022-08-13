package portfolio.portfolioBack.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Imagen {
    private long idImagen;
    private String urlImagen;

    public Imagen() {
    }

    public Imagen(long idImagen, String urlImagen) {
        this.idImagen = idImagen;
        this.urlImagen = urlImagen;
    }
    
    
}
