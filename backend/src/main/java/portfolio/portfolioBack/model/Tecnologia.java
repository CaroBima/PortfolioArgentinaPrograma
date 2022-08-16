

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
public class Tecnologia {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private long idTecnologia;
   
   private String nombreTecnologia;

    public Tecnologia(long idTecnologia, String tecnologia) {
        this.idTecnologia = idTecnologia;
        this.nombreTecnologia = tecnologia;
    }
   
   
}
