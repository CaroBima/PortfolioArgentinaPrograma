

package portfolio.portfolioBack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portfolio.portfolioBack.model.Usuario;
import portfolio.portfolioBack.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    IUsuarioRepository usuarioRepo;

    private final PasswordEncoder passwordEncoder;

    // Constructor-based dependency injection
    @Autowired
    public UsuarioService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void crearUsuario(Usuario usuario) {
        Usuario usuarioSave = new Usuario();
        usuarioSave.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
        usuarioSave.setNombreUsuario(usuario.getNombreUsuario());

        usuarioRepo.save(usuarioSave);
    }

    @Override
    public Usuario buscarUnUsuario(Long idUsuario) {
        return usuarioRepo.findById(idUsuario).orElse(null);
    }
    
    //metodo que permite buscar un usuario por nombre y clave
    @Override
    public boolean logueoUsuario (Usuario usuario){
        boolean logueo = false;
        Usuario usuGuardado = new Usuario();

        String claveIngresada = passwordEncoder.encode(usuario.getContrasenia()); // codifico la clave que ingreso el usuario para compararla

        try {
            usuGuardado = usuarioRepo.findByNombreUsuario(usuario.getNombreUsuario()); //busco el usuario por el nombre de usuario ingresado

            if (usuGuardado != null) {
                if (usuario.getNombreUsuario().equals(usuGuardado.getNombreUsuario()) && usuario.getContrasenia().equals(claveIngresada)) {
                    logueo = true;
                } else logueo = false;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return logueo;
    }
    
}
