package portfolio.portfolioBack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.portfolioBack.model.Curso;
import portfolio.portfolioBack.model.Tecnologia;
import portfolio.portfolioBack.model.Tema;
import portfolio.portfolioBack.repository.ICursoRepository;


@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private ICursoRepository cursoRepo;
    
    @Autowired
    private ITemaService temaService;
    
    @Autowired 
    private ITecnologiaService tecnologiaService; 
    

    @Override
    public void guardarCurso(Curso curso) {
        //verifica si los temas ya estan guardados y si no lo estan los guarda
        curso.setListaTemas(temaService.guardarTema(curso.getListaTemas()));
        
        curso.setListaTecnologias(tecnologiaService.guardarTecnologia(curso.getListaTecnologias()));
        
        cursoRepo.save(curso);
    }

    @Override
    public List<Curso> traerCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public Curso buscarUnCurso(Long idCurso) {
        return cursoRepo.findById(idCurso).orElse(null);
    }
    
    
    @Override
    public Curso modificarCurso(Long idCurso, String nuevoTit, String nuevoNomb, String nuevaInstit, String nuevaDesc, String nuevaImagen, String nuevaDurac, List<Tecnologia> nvaListaTecnol) {
       Curso curso = this.buscarUnCurso(idCurso);
       
       if(nuevoTit!= null){
           curso.setTituloCurso(nuevoTit);
       }
       
       if(nuevoNomb != null){
           curso.setNombreCurso(nuevoNomb);
       }
    
       if(nuevaInstit != null){
           curso.setInstitucion(nuevaInstit);
       }
       
       if(nuevaDesc != null){
           curso.setDescripcion(nuevaDesc);
       }
       
       if(nuevaImagen != null){
           curso.setImagen(nuevaImagen);
       }
       
       if(nuevaDurac != null){
           curso.setDuracionCurso(nuevaDurac);
       }
       if(nvaListaTecnol != null){
           this.modificarTecnolCurso(nvaListaTecnol);
       }
       
       this.guardarCurso(curso);
       return curso;
    }
    

    @Override
    public void eliminarUnCurso(Long idCurso) {
        cursoRepo.deleteById(idCurso);
    }

    
//permite modificar las tecnologías vistas en el curso (Ej: java, angular, css, etc)
    @Override
    public void modificarTecnolCurso(List<Tecnologia> nvaListaTecnologias) {
        //recorrer la lista, encontrar tecnologia que no esta más y borrarla de la tabla intermedia
        //ver si hay tecnologias nuevas que no estaban y agregarlas
    }
    
    
}
