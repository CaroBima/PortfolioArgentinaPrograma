
package portfolio.portfolioBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.portfolioBack.model.Curso;
import portfolio.portfolioBack.model.Tecnologia;
import portfolio.portfolioBack.service.ITecnologiaService;

@RestController
public class TecnologiaController {
    @Autowired
    ITecnologiaService tecnologiaService;
    
    
    @PostMapping("/nuevaTecnologia")
    public void guardarTecnologia(@RequestBody Tecnologia tecnologia){
        tecnologiaService.guardarTecnologia(tecnologia);
    }
}
