package cogent.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import cogent.entities.Batch;

@CrossOrigin() 
public interface BatchRepository extends JpaRepository<Batch, Long>{
	
	public Optional<Batch> findByBatchCode(@RequestParam("batchCode") String batchCode);

}
