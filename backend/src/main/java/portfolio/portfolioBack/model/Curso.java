package portfolio.portfolioBack.model;


public class Curso {
    //pk 
    private long idCurso;
    
    private String tituloCurso;
    private String nombreCurso;
    private String institucion;
    private String descripcion;
    private String linkImg;
    private String duracionCurso;
   //FK
    private Tema temas;
    
    //Fk
    private Tecnologia tecnologia;

    public Curso() {
    }

    public Curso(long idCurso, String tituloCurso, String nombreCurso, String institucion, String descripcion, String linkImg, String duracionCurso, Tema temas, Tecnologia tecnologia) {
        this.idCurso = idCurso;
        this.tituloCurso = tituloCurso;
        this.nombreCurso = nombreCurso;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.linkImg = linkImg;
        this.duracionCurso = duracionCurso;
        this.temas = temas;
        this.tecnologia = tecnologia;
    }
    
    
    
}
