package portfolio.portfolioBack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.portfolioBack.model.Curso;
import portfolio.portfolioBack.model.Tecnologia;
import portfolio.portfolioBack.repository.ICursoRepository;


@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private ICursoRepository cursoRepo;

    @Override
    public void guardarCurso(Curso curso) {
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
    public Curso modificarCurso(Long idCurso, String nuevoTit, String nuevoNomb, String nuevaInstit, String nuevaDesc, String nuevoLink, String nuevaDurac, List<Tecnologia> nvaListaTecnol) {
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
       
       if(nuevoLink != null){
           curso.setLinkImg(nuevoLink);
       }
       
       if(nuevaDurac != null){
           curso.setDuracionCurso(nuevaDurac);
       }
       if(nvaListaTecnol != null){
           this.modificarTecnologias(nvaListaTecnol);
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
    public void modificarTecnologias(List<Tecnologia> nvaListaTecnologias) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
