package portfolio.portfolioBack.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import portfolio.portfolioBack.model.Curso;
import portfolio.portfolioBack.service.ICursoService;

@RestController
public class CursoController {
    
    @Autowired
    ICursoService cursoService;
    
    
    @PostMapping("/cursos/nuevocurso")
    public void guardarCurso(@RequestBody Curso curso){
        cursoService.guardarCurso(curso);
    }
    
    
    @GetMapping("/buscarcursos")
    public List<Curso> buscarCursos(){
        return cursoService.traerCursos();
    }

    @GetMapping("/buscarcurso")
    public Curso buscarUnCurso (@RequestParam Long idCurso){
        return cursoService.buscarUnCurso(idCurso);
    }
    
    
    
}
