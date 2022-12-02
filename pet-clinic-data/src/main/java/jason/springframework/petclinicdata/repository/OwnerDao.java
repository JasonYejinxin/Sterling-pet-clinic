package jason.springframework.petclinicdata.repository;

import jason.springframework.petclinicdata.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OwnerDao extends JpaRepository<Owner,Integer> {

    @Transactional
    @Query(value = "insert into OWNER(email,password,address,city,telephone) values(:email,:password,:address,:city,:telephone)", nativeQuery = true)
    @Modifying
    int insertOwner(@Param("email") String email, @Param("password") String password, @Param("address") String address,
                    @Param("city") String city, @Param("telephone") String telephone);

    @Transactional
    @Query(value = "select * from OWNER where email = :email and password = :password", nativeQuery = true)
    @Modifying
    List<Owner> findOwnerByUnameAndPassword(@Param("email") String email, @Param("password") String password);

    @Transactional
    @Query(value = "select * from OWNER where email = :email", nativeQuery = true)
    @Modifying
    List<Owner> findByEmail(@Param("email") String email);

    Owner findByEmailAndPassword(String email, String password);

}
