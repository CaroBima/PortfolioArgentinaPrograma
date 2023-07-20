
package portfolio.portfolioBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.portfolioBack.model.Usuario;


public interface IUsuarioRepository  extends  JpaRepository<Usuario, Long>{

    Usuario findByNombreUsuario(String username);
}
