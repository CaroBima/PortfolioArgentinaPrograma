
package portfolio.portfolioBack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.portfolioBack.model.Imagen;
import portfolio.portfolioBack.service.IImagenService;


@CrossOrigin
@RestController
public class ImagenController {
    @Autowired
    IImagenService imagenService;
    
    @GetMapping("/buscarimagenes")
    public List<Imagen> buscarImagenes(){
        return imagenService.traerImagenes(); 
    }
    
       @PostMapping("/proyecto/guardarimagen")
    public void guardarProyecto(@RequestBody Imagen imagen){
        imagenService.guardarImagen(imagen);
    }
}
