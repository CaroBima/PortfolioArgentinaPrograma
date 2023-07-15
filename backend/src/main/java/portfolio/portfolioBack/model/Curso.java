package portfolio.portfolioBack.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name="curso")
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCurso;
    
    private String tituloCurso;
    private String nombreCurso;
    private String institucion;
    private String descripcion;
    
    @Lob
    @Column(name = "imagen", columnDefinition="LONGBLOB")
    private String imagen;
    
    private String duracionCurso;
    private String linkCurso;
   
   @JoinTable(name = "temasxcurso", joinColumns = {
            @JoinColumn(name = "idCurso", nullable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "idTema", nullable = false)})
    @ManyToMany  //(cascade = CascadeType.ALL)
    private List<Tema> listaTemas; 
    
   
    @JoinTable(name = "tecnoxcurso", joinColumns = {
            @JoinColumn(name = "idCurso", nullable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "idTecnologia", nullable = false)})
    @ManyToMany 
    private List<Tecnologia> listaTecnologias; 

       
}
