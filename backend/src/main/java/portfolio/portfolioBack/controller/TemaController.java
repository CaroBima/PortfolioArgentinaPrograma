
package portfolio.portfolioBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.portfolioBack.model.Tema;
import portfolio.portfolioBack.service.ITemaService;


@RestController
public class TemaController {
    @Autowired
    ITemaService temaService;
    
    
    @PostMapping("/nuevoTema")
    public void guardarTecnologia(@RequestBody Tema tema){
        temaService.guardarTema(tema);
    }
}
