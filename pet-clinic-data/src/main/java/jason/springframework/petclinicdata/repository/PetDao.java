package jason.springframework.petclinicdata.repository;

import jason.springframework.petclinicdata.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetDao extends JpaRepository<Pet,Integer> {
}
