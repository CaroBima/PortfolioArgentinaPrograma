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
public class Tema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idTema;
    
    @Column(unique=true)
    private String nombreTema;
    
//    @JsonBackReference
//    @ManyToMany(mappedBy = "listaTemas", fetch=FetchType.LAZY)
//    private List<Curso> listaCursos;
}
