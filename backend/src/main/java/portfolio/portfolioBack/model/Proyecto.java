

package portfolio.portfolioBack.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Proyecto {
    private long idProyecto;
    private String nombre;
    private String descripcion;
    
    //fk
    private Imagen imagenes;
    private String descripcionAmplia;
    private String url;
    private String linkRepo;

    public Proyecto() {
    }

    public Proyecto(long idProyecto, String nombre, String descripcion, Imagen imagenes, String descripcionAmplia, String url, String linkRepo) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
        this.descripcionAmplia = descripcionAmplia;
        this.url = url;
        this.linkRepo = linkRepo;
    }

 
    
    
}
