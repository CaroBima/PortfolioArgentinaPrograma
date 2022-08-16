

package portfolio.portfolioBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idProyecto;
    
    private String nombre;
    private String descripcion;
    private String descripcionAmplia;
    private String url;
    private String linkRepo;
    
    //fk
    @OneToMany
    private Imagen imagenes;
    

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
