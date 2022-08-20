

package portfolio.portfolioBack.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tecnologia")
public class Tecnologia {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long idTecnologia;
   
   @Column(unique=true)
   private String nombreTecnologia;

//   @ManyToMany (mappedBy = "listaTecnologias")
//   private List<Curso>  listaCursos;
   
}
   
   

