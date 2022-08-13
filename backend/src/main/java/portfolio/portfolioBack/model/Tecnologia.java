

package portfolio.portfolioBack.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Tecnologia {
   private long idTecnologia;
   private String tecnologia;

    public Tecnologia(long idTecnologia, String tecnologia) {
        this.idTecnologia = idTecnologia;
        this.tecnologia = tecnologia;
    }
   
   
}
