
package portfolio.portfolioBack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import portfolio.portfolioBack.model.Proyecto;
import portfolio.portfolioBack.service.IProyectoService;

@CrossOrigin
@RestController
public class ProyectoController {
    
    @Autowired
    IProyectoService proyectoService;
    
    @GetMapping("/buscarproyectos")
    public List<Proyecto> buscarProyectos(){
        return proyectoService.traerProyectos();
    }
    
      @PostMapping("/proyecto/nuevoproyecto")
    public void guardarProyecto(@RequestBody Proyecto proyecto){
        proyectoService.guardarProyecto(proyecto);
    }
    
    
     @GetMapping("/buscarproyecto")
    public Proyecto buscarUnCurso (@RequestParam Long idProyecto){
        return proyectoService.buscarUnProyecto(idProyecto);
    }
}
