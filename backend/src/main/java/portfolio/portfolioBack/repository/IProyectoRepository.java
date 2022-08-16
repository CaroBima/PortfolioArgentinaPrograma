

package portfolio.portfolioBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.portfolioBack.model.Proyecto;




public interface IProyectoRepository extends  JpaRepository<Proyecto, Long> {
    
}
