package jason.springframework.petclinicdata.repository;

import jason.springframework.petclinicdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    @Transactional
    @Query(value = "insert into users(uname,password) values(:uname,:password)", nativeQuery = true)
    @Modifying
    int insertRule(@Param("uname") String uname, @Param("password") String password);

    User findByUname(String uname);
    User findByUnameAndPassword(String uname, String password);

}
