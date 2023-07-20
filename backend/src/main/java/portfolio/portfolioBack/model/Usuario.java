package portfolio.portfolioBack.model;


/*
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;*/
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import portfolio.portfolioBack.security.Authority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario implements UserDetails {
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idUsuario;
     
    private String nombreUsuario;
    private String contrasenia;
    private String email;

    @ManyToOne
    private RolUsuario rolUsuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*Set<Authority> autoridades = new HashSet<>();
        this.rolUsuario.forEach(rolUsuario ->{
            autoridades.add(new Authority(rolUsuario.))
        });*/
        Authority autoridad = new Authority(rolUsuario.getNombreRol());

        return  Collections.singleton(autoridad);
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //expiración de la cuenta
        /*
        * Comprueba si la cuenta del usuario ha caducado y no es válida (false) o está activa (true). Utilizado para
        * establecer políticas de seguridad en las cuales las cuentas de usuario tienen una fecha de vencimiento
        * después de la cual ya no se les permite el acceso. Útil, por ejemplo, para cuentas temporales
        * o de prueba que solo son válidas por un período específico.
        */
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
        /*
        * Comprueba si la cuenta del usuario está bloqueada (false) o no (true). Útil para implementar mecanismos de
        * bloqueo de cuentas después de múltiples intentos fallidos de inicio de sesión.
        */
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
        /*
        * Permite comprobar si las credenciales del usuario (como la contraseña) han caducado (false) o no (true,
        * credenciales aún válidas). Se utiliza para obligar a los usuarios a cambiar sus contraseñas periódicamente.
        * Esta práctica ayuda a reducir el riesgo de que las contraseñas se vean comprometidas debido a su uso prolongado.
        */
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
