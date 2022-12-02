package jason.springframework.petclinicdata.repository;

import jason.springframework.petclinicdata.model.Owner;
import jason.springframework.petclinicdata.model.User;
import jason.springframework.petclinicdata.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface VetDao extends JpaRepository<Vet,Integer> {
    @Transactional
    @Query(value = "insert into vet(email,password,specialties,start_of_career) values(:email,:password,:specialties,:startOfCareer)", nativeQuery = true)
    @Modifying
    int insertVet(@Param("email") String email, @Param("password") String password, @Param("specialties") String specialties,
                    @Param("startOfCareer") Date startOfCareer);

    @Transactional
    @Query(value = "select * from vet where email = :email and password = :password", nativeQuery = true)
    @Modifying
    List<Vet> findVetByUnameAndPassword(@Param("email") String email, @Param("password") String password);

    Vet findByEmail(String email);
    Vet findByEmailAndPassword(String email, String password);

}
