package cogent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import cogent.entities.Batch;

@CrossOrigin() 
public interface BatchRepository extends JpaRepository<Batch, Long>{

}
