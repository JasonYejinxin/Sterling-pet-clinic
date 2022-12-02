package jason.springframework.petclinicdata.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Table(name = "vet")
@Entity
public class Vet extends User{
    @Column(name = "specialties")
    private String specialties;
    @Column(name = "startOfCareer")
    @DateTimeFormat(pattern ="MM/dd/yyyy")
    private Date startOfCareer;

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    public Date getStartOfCareer() {
        return startOfCareer;
    }

    public void setStartOfCareer(Date startOfCareer) {
        this.startOfCareer = startOfCareer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vet vet = (Vet) o;
        return Objects.equals(specialties, vet.specialties) && Objects.equals(startOfCareer, vet.startOfCareer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialties, startOfCareer);
    }

    @Override
    public String toString() {
        return "Vet{" +
                "specialties='" + specialties + '\'' +
                ", startOfCareer=" + startOfCareer +
                '}';
    }
}
