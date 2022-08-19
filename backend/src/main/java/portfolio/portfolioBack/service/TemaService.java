package portfolio.portfolioBack.service;

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

    @Override
    public List<Tema> traerTemas() {
        return temaRepo.findAll();
    }

    
    @Override
    public Tema modificarTemas(Long idTema, String nvoTema) {
        Tema tema = temaRepo.findById(idTema).orElse(null);
        if(tema != null && nvoTema != null){ //si el tema existe y se paso un cambio en el nombre de la tematica entra
            tema.setTema(nvoTema);
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
