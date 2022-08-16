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
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idTema;
    
    private String tema;

    public Tema() {
    }

    public Tema(long idTema, String tema) {
        this.idTema = idTema;
        this.tema = tema;
    }
    
}
