package portfolio.portfolioBack.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idTema;
    
    //@Column(unique=true)
    private String tema;
    
//    @JsonBackReference
//    @ManyToMany(mappedBy = "listaTemas", fetch=FetchType.LAZY)
//    private List<Curso> listaCursos;
}
