package portfolio.portfolioBack.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;




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
@Table(name = "curso")
public class Curso {
    //pk 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCurso;
    
    private String tituloCurso;
    private String nombreCurso;
    private String institucion;
    private String descripcion;
    private String linkImg;
    private String duracionCurso;
    private String linkCurso;
   

    
    
    @OneToMany 
    (cascade = {CascadeType.MERGE})
    @JoinTable(name = "temaxcurso", joinColumns = {
            @JoinColumn(name = "idCurso", nullable = false, insertable = true)},
            inverseJoinColumns = {
            @JoinColumn(name = "idTema", nullable = false, insertable = true)})
    private List<Tema> listaTemas; // = new ArrayList<Tema>();
    
  
    @OneToMany  (cascade ={CascadeType.MERGE} ) 
    @JoinTable(name = "tecnolxcurso", joinColumns = {
            @JoinColumn(name = "idCurso", nullable = false, insertable = true)},
            inverseJoinColumns = {
            @JoinColumn(name = "idTecnologia", nullable = false, insertable = true)})
    private List<Tecnologia> listaTecnologias; //= new ArrayList<Tecnologia>();

       
}
