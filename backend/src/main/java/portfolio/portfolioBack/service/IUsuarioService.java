

package portfolio.portfolioBack.service;



import portfolio.portfolioBack.model.Usuario;


public interface IUsuarioService {
    public void crearUsuario(Usuario usuario);
    //public List<Usuario> traerUsuarios();
    //public Usuario modificarUsuario(Long idUsuario);
    public Usuario buscarUnUsuario(Long idUsuario);
    //public void eliminarUnUsuario(Long idUsuario);
}
