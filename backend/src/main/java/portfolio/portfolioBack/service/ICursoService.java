

package portfolio.portfolioBack.service;

import java.util.List;
import portfolio.portfolioBack.model.Curso;
import portfolio.portfolioBack.model.Tecnologia;



public interface ICursoService {
    public void crearCurso(Curso curso);
    public List<Curso> traerCursos();
    public Curso modificarCurso(Long idCurso, String nuevoTit, String nuevoNomb, String nuevaInstit, String nuevaDesc, String nuevoLink, String nuevaDurac, List<Tecnologia> nuevaListaTecn);
    public Curso buscarUnCurso(Long idCurso);
    public void eliminarUnCurso(Long idCurso);
    
    
}
