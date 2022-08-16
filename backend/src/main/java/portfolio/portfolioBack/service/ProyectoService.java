

package portfolio.portfolioBack.service;

import java.util.List;
import org.springframework.stereotype.Service;
import portfolio.portfolioBack.model.Imagen;
import portfolio.portfolioBack.model.Proyecto;

 @Service
public class ProyectoService implements IProyectoService{

    @Override
    public void crearProyecto(Proyecto proyecto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Proyecto> traerProyectos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proyecto modificarProyecto(Long idProyecto, String nvoNomb, String nuevaDesc, String nuevaDescAmpl, String nvaUrl, String nvoLinkRepo, List<Imagen> nvaListaImg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proyecto buscarUnProyecto(Long idProyecto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarUnProyecto(Long idProyecto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
