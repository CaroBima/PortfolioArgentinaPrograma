package portfolio.portfolioBack.service;

import java.util.List;
import portfolio.portfolioBack.model.Tema;


public interface ITemaService {
    public void guardarTema(Tema tema);
    public List<Tema> guardarTema(List<Tema> listaTemas);
    public List<Tema> traerTemas();
    public Tema modificarTemas(Long idTema, String nvoTema);
    public Tema buscarUnTema(Long idTema);
    public void eliminarTema(Long idTema);
}
