

package portfolio.portfolioBack.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
   
   

