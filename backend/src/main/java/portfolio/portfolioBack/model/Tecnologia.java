

package portfolio.portfolioBack.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;
import java.util.Set;
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
public class Tecnologia {
   
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long idTecnologia;
   
  @Column(unique=true)
  private String nombreTecnologia;
  
  
//    @JsonBackReference
//    @ManyToMany(mappedBy = "listaTecnologias", fetch=FetchType.LAZY)
//    private List<Curso> listaCursos;

}
   
   

