

package portfolio.portfolioBack.service;

import java.util.List;
import portfolio.portfolioBack.model.Tecnologia;



public interface ITecnologiaService {
    public void guardarTecnologia(Tecnologia tecnologia);
    public List<Tecnologia> guardarTecnologia(List<Tecnologia> tecnologia);
    public List<Tecnologia> traerTecnologias();
    public Tecnologia modificarTecnologia(Long idTecnologia, String nvoNomTecnol);
    public Tecnologia buscarUnaTecnologia(Long idTecnologia);
    public void eliminarTecnologia(Long idTecnologia);
    
}
