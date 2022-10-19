
package portfolio.portfolioBack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.portfolioBack.model.Tecnologia;
import portfolio.portfolioBack.repository.ITecnologiaRepository;

@Service
public class TecnologiaService implements ITecnologiaService{

    @Autowired
    ITecnologiaRepository tecnoRepo;
    
    @Override
    public void guardarTecnologia(Tecnologia tecnologia) {
        tecnoRepo.save(tecnologia);
    }
    
     @Override
    public List<Tecnologia> guardarTecnologia(List<Tecnologia> listaTecnologias) {
         List<Tecnologia> listaTecnolGuardada = this.traerTecnologias();
        boolean yaGuardado = false;
        
        //comparo la lista de temas con la traida de la bbdd
        for (Tecnologia tecnologia : listaTecnologias){
            for(Tecnologia tecnologiaBD : listaTecnolGuardada){
                if(tecnologiaBD.getNombreTecnologia().toLowerCase().equals(tecnologia.getNombreTecnologia().toLowerCase())){
                    yaGuardado = true;
                    
                }
            }
            if(!yaGuardado){
                tecnoRepo.save(tecnologia);
            }else{
                yaGuardado = false;
            }
        }
        
        //guardo en el array los id de las tecnologias
         for (Tecnologia tecnologia : listaTecnologias){
            for(Tecnologia tecnologiaBD : listaTecnolGuardada){
                if(tecnologiaBD.getNombreTecnologia().toLowerCase().equals(tecnologia.getNombreTecnologia().toLowerCase())){
                    tecnologia.setIdTecnologia(tecnologiaBD.getIdTecnologia());
                    
                }
            }
        }
  
        return listaTecnologias;
    }

    @Override
    public List<Tecnologia> traerTecnologias() {
        return tecnoRepo.findAll();
    }

    @Override
    public Tecnologia modificarTecnologia(Long idTecnologia, String nvoNomTecnol) {
        Tecnologia tecno = this.buscarUnaTecnologia(idTecnologia);
        
        if(nvoNomTecnol != null){
            tecno.setNombreTecnologia(nvoNomTecnol);
        }
        
        this.guardarTecnologia(tecno);
        return tecno;
    }
 
    @Override
    public Tecnologia buscarUnaTecnologia(Long idTecnologia) {
        return tecnoRepo.findById(idTecnologia).orElse(null);
    }

    @Override
    public void eliminarTecnologia(Long idTecnologia) {
        tecnoRepo.deleteById(idTecnologia);
    }

   
    
}
