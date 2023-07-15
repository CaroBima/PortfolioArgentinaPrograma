

package portfolio.portfolioBack.model;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idProyecto;
    
    private String nombre;
    private String descripcion;
    private String descripcionAmplia;
    private String imgPrev; //imagen de previsualizacion del curso
    private String url; 
    private String linkRepo;
    
    
    //fk
     @JoinTable(name = "imagenxproyecto", joinColumns = {
            @JoinColumn(name = "idProyecto", nullable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "idImagen", nullable = false)})
    @ManyToMany 
    (cascade = CascadeType.MERGE)
    private List<Imagen> imagenes;
    


     

  

 
    
    
}
