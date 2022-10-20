
package portfolio.portfolioBack.service;

import java.util.List;
import portfolio.portfolioBack.model.Curso;
import portfolio.portfolioBack.model.Tecnologia;



public interface ICursoService {
    public void guardarCurso(Curso curso);
    public List<Curso> traerCursos();
    public Curso modificarCurso(Long idCurso, String nuevoTit, String nuevoNomb, String nuevaInstit, String nuevaDesc, String nuevaImagen, String nuevaDurac, List<Tecnologia> nvaListaTecnol);
    public Curso buscarUnCurso(Long idCurso);
    public void eliminarUnCurso(Long idCurso);
    public void modificarTecnolCurso(List<Tecnologia> nvaListaTecnologias);
    
    
}
