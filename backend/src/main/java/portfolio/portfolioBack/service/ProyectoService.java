

package portfolio.portfolioBack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.portfolioBack.model.Imagen;
import portfolio.portfolioBack.model.Proyecto;
import portfolio.portfolioBack.repository.IProyectoRepository;

 @Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private IProyectoRepository proyectoRepo;
             
    @Override
    public void guardarProyecto(Proyecto proyecto) {
        proyectoRepo.save(proyecto);
    }

    @Override
    public List<Proyecto> traerProyectos() {
        return proyectoRepo.findAll();
    }

    @Override
    public Proyecto modificarProyecto(Long idProyecto, String nvoNomb, String nuevaDesc, String nuevaDescAmpl, String nvaUrl, String nvoLinkRepo, List<Imagen> nvaListaImg) {
        Proyecto proyecto = this.buscarUnProyecto(idProyecto);
        
        if(nvoNomb != null){
            proyecto.setNombre(nvoNomb);
        }
        
        if(nuevaDesc != null){
            proyecto.setDescripcion(nuevaDesc);
        }
        
        if(nuevaDescAmpl != null){
            proyecto.setDescripcionAmplia(nuevaDescAmpl);
        }
        
        if(nvaUrl != null){
            proyecto.setUrl(nvaUrl);
        }
        if(nvoLinkRepo != null){
            proyecto.setLinkRepo(nvoLinkRepo);
        }
        if(nvaListaImg != null){
            proyecto.setImagenes(nvaListaImg);
        }
       
        this.guardarProyecto(proyecto);
        return proyecto;
    }

    @Override
    public Proyecto buscarUnProyecto(Long idProyecto) {
        return proyectoRepo.findById(idProyecto).orElse(null);
    }

    @Override
    public void eliminarUnProyecto(Long idProyecto) {
        proyectoRepo.deleteById(idProyecto);
    }

   
    
}
