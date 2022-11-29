package jason.springframework.petclinicdata.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
public class User extends BaseEntity{

    @Column(name = "uname")
    private String uname;
    @Column(name = "password")
    private String password;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(uname, user.uname) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uname, password);
    }
}
