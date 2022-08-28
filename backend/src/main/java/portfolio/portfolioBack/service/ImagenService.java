

package portfolio.portfolioBack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.portfolioBack.model.Imagen;
import portfolio.portfolioBack.repository.IImagenRepository;


@Service
public class ImagenService implements IImagenService{

    @Autowired
    IImagenRepository imagenRepo;
    
    @Override
    public void guardarImagen(Imagen imagen) {
        imagenRepo.save(imagen);
    }

    @Override
    public List<Imagen> traerImagenes() {
        return imagenRepo.findAll();
    }

    @Override
    public Imagen buscarUnaImagen(Long idImagen) {
        return imagenRepo.findById(idImagen).orElse(null);
    }

    @Override
    public void eliminarUnaImagen(Long idImagen) {
        imagenRepo.existsById(idImagen);
    }
    
}
