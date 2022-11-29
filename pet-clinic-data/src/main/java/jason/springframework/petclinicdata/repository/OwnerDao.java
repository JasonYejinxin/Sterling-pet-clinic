package jason.springframework.petclinicdata.repository;

import jason.springframework.petclinicdata.model.Owner;
import jason.springframework.petclinicdata.model.User;
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
    @Query(value = "insert into OWNER(uname,password,address,city,telephone) values(:uname,:password,:address,:city,:telephone)", nativeQuery = true)
    @Modifying
    int insertOwner(@Param("uname") String userName, @Param("password") String password, @Param("address") String address,
                    @Param("city") String city, @Param("telephone") String telephone);

    @Transactional
    @Query(value = "select * from OWNER where uname = :uname and password = :password", nativeQuery = true)
    @Modifying
    List<Owner> findOwnerByUnameAndPassword(@Param("uname") String uname, @Param("password") String password);

    Owner findByUname(String uname);
    Owner findByUnameAndPassword(String uname, String password);

}
