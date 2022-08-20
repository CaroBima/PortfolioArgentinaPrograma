

package portfolio.portfolioBack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.portfolioBack.model.Usuario;
import portfolio.portfolioBack.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    IUsuarioRepository usuarioRepo;
    
    @Override
    public void crearUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    @Override
    public Usuario buscarUnUsuario(Long idUsuario) {
        return usuarioRepo.findById(idUsuario).orElse(null);
    }
    
    //metodo que permite buscar un usuario por nombre y clave
    public boolean logueoUsuario (Usuario usuario){
        boolean logueoOk = false;
        List<Usuario> listaUsuarios = usuarioRepo.findAll();
        
        for(Usuario usu : listaUsuarios){
            if(usu.getNombreUsuario().equals(usuario.getNombreUsuario()) && usu.getContrasenia().equals(usuario.getContrasenia())){
                logueoOk = true;
            }
        }
        
        return logueoOk;
    }
    
}
