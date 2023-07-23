

package portfolio.portfolioBack.service;



import portfolio.portfolioBack.model.Usuario;


public interface IUsuarioService {
    public int crearUsuario(Usuario usuario);
    //public List<Usuario> traerUsuarios();
    //public Usuario modificarUsuario(Long idUsuario);
    public Usuario buscarUnUsuario(Long idUsuario);
    public boolean logueoUsuario (Usuario usuario);
    //public void eliminarUnUsuario(Long idUsuario);
}
