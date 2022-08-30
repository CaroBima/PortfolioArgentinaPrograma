
package portfolio.portfolioBack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.portfolioBack.model.Tecnologia;
import portfolio.portfolioBack.service.ITecnologiaService;

@CrossOrigin
@RestController
public class TecnologiaController {
    @Autowired
    ITecnologiaService tecnologiaService;
    
    
    @PostMapping("/nuevaTecnologia")
    public void guardarTecnologia(@RequestBody Tecnologia tecnologia){
        //traigo la lista de tecnologías y reviso si la tecnología ya se encuentra guardada
        List<Tecnologia> listaTecnologias= tecnologiaService.traerTecnologias();
        boolean yaEsta = false;
        //recorro el array para ver si la tecnologia ya se encuentra guardada
        for( Tecnologia tecno : listaTecnologias){
            if(tecno.getNombreTecnologia().equals(tecnologia.getNombreTecnologia())){
               yaEsta = true; 
            }
        }
        //si no esta en el listado la guardo
        if(!yaEsta){
        tecnologiaService.guardarTecnologia(tecnologia);
        }else{//console log de prueba
            System.out.println("La tecnologia ya esta");
        }
        
    }
    
    //recupera el listado de tecnologias y lo retorna
    @GetMapping("/buscarTecnologias")
    public List<Tecnologia> buscarTecnologias(){
        return tecnologiaService.traerTecnologias();
    }

}
