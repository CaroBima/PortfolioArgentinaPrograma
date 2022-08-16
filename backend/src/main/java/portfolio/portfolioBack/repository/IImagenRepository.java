

package portfolio.portfolioBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.portfolioBack.model.Imagen;



public interface IImagenRepository  extends  JpaRepository<Imagen, Long> {
    
}
