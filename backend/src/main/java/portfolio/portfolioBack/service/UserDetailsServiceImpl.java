package portfolio.portfolioBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import portfolio.portfolioBack.model.Usuario;
import portfolio.portfolioBack.repository.IUsuarioRepository;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepo.findByNombreUsuario(username);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return usuario;
    }
}
