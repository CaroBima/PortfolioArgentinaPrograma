

package portfolio.portfolioBack.service;

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
    
}
