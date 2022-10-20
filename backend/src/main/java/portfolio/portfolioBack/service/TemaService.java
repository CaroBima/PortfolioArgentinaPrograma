package portfolio.portfolioBack.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.portfolioBack.model.Tema;
import portfolio.portfolioBack.repository.ITemaRepository;


@Service
public class TemaService implements ITemaService {
    @Autowired
    ITemaRepository temaRepo;
    
    
    @Override
    public void guardarTema(Tema tema) {
        temaRepo.save(tema);
    }

    //permite guardar los temas nuevos que no se encuentren previamente en la bbdd recibiendo una lista de temas
    @Override
    public List<Tema> guardarTema(List<Tema> listaTemas) {
        List<Tema> listaTemasGuardada = this.traerTemas();
        boolean yaGuardado = false;
        
        for (Tema tema : listaTemas){
            for(Tema temaBD : listaTemasGuardada){
                if(tema.getNombreTema().equalsIgnoreCase(temaBD.getNombreTema()) && tema.getIdTema()==null){    
                    tema.setIdTema(temaBD.getIdTema());
                    yaGuardado = true;
                    
                } 
                
            }
            if (yaGuardado == false && tema.getIdTema()==null){
                tema = (temaRepo.save(tema));
            }
            yaGuardado = false;
        }
      /*
        for (Tema tema : listaTemas){
            System.out.println("id: " + tema.getIdTema());
            System.out.println("id: " + tema.getNombreTema());
        }
      */
      
      return listaTemas;
    }
    
    
    @Override
    public List<Tema> traerTemas() {
        return temaRepo.findAll();
    }

    
    @Override
    public Tema modificarTemas(Long idTema, String nvoTema) {
        Tema tema = temaRepo.findById(idTema).orElse(null);
        if(tema != null && nvoTema != null){ //si el tema existe y se paso un cambio en el nombre de la tematica entra
            tema.setNombreTema(nvoTema);
            temaRepo.save(tema);
        }
        
        return tema;
    }

    @Override
    public Tema buscarUnTema(Long idTema) {
        return temaRepo.findById(idTema).orElse(null);
    }

    @Override
    public void eliminarTema(Long idTema) {
        temaRepo.deleteById(idTema);
    }

   
}
