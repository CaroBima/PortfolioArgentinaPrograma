

package portfolio.portfolioBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.portfolioBack.model.Tema;




public interface ITemaRepository extends  JpaRepository<Tema, Long> {
    
}
