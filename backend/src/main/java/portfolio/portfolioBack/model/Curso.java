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
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso {
    //pk 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idCurso;
    
    private String tituloCurso;
    private String nombreCurso;
    private String institucion;
    private String descripcion;
    private String linkImg;
    private String duracionCurso;
    private String linkCurso;
   
//FK
    @JoinTable(name = "temaxcurso", joinColumns = {
            @JoinColumn(name = "idCurso", nullable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "idTema", nullable = false)})
    @ManyToMany 
    (cascade = CascadeType.MERGE)
    private List<Tema> temas;
    
    //Fk
    @JoinTable(name = "tecnolxcurso", joinColumns = {
            @JoinColumn(name = "idCurso", nullable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "idTecnologia", nullable = false)})
    @ManyToMany 
    (cascade = CascadeType.MERGE)
    private List<Tecnologia> tecnologia;

    public Curso() {
    }

    public Curso(long idCurso, String tituloCurso, String nombreCurso, String institucion, String descripcion, String linkImg, String duracionCurso, String linkCurso, List<Tema> temas, List<Tecnologia> tecnologia) {
        this.idCurso = idCurso;
        this.tituloCurso = tituloCurso;
        this.nombreCurso = nombreCurso;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.linkImg = linkImg;
        this.duracionCurso = duracionCurso;
        this.linkCurso = linkCurso;
        this.temas = temas;
        this.tecnologia = tecnologia;
    }

 
 
    
    
    
}
