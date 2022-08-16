

package portfolio.portfolioBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.portfolioBack.model.Tecnologia;


public interface ITecnologiaRepository extends  JpaRepository<Tecnologia, Long>{
    
}
