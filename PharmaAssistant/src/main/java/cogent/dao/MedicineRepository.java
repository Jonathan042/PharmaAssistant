package cogent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import cogent.entities.Medicine;

@CrossOrigin
//@RepositoryRestResource(collectionResourceRel = "medicine", path = "medicine")
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}
