

package portfolio.portfolioBack.service;

import java.util.List;
import org.springframework.stereotype.Service;
import portfolio.portfolioBack.model.Curso;
import portfolio.portfolioBack.model.Tecnologia;


@Service
public class CursoService implements ICursoService{

    @Override
    public void crearCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Curso> traerCursos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Curso modificarCurso(Long idCurso, String nuevoTit, String nuevoNomb, String nuevaInstit, String nuevaDesc, String nuevoLink, String nuevaDurac, List<Tecnologia> nuevaListaTecn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Curso buscarUnCurso(Long idCurso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarUnCurso(Long idCurso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
