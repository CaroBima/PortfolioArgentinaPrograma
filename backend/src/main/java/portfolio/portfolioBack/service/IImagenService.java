package portfolio.portfolioBack.service;

import java.util.List;
import portfolio.portfolioBack.model.Imagen;


public interface IImagenService {
    public void guardarImagen(Imagen imagen);
    public List<Imagen> traerImagenes();
    public Imagen buscarUnaImagen(Long idImagen);
    public void eliminarUnaImagen(Long idImagen);
    
}
