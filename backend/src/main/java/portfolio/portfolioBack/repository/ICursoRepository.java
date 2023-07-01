
package portfolio.portfolioBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.portfolioBack.model.Curso;


public interface ICursoRepository extends JpaRepository<Curso, Long> {
    
}
