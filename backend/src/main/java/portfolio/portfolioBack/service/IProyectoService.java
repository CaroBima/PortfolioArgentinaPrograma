

package portfolio.portfolioBack.service;

import java.util.List;
import portfolio.portfolioBack.model.Imagen;
import portfolio.portfolioBack.model.Proyecto;



public interface IProyectoService {
    public void guardarProyecto(Proyecto proyecto);
    public List<Proyecto> traerProyectos();
    public Proyecto modificarProyecto(Long idProyecto, String nvoNomb, String nuevaDesc, String nuevaDescAmpl, String nvaUrl, String nvoLinkRepo, List<Imagen> nvaListaImg);
    public Proyecto buscarUnProyecto(Long idProyecto);
    public void eliminarUnProyecto(Long idProyecto);
}
