package jason.springframework.petclinicdata.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "pet")
@Entity
public class Pet extends BaseEntity{
    private String petName;
    private String petType;
    private String ownerId;
    private LocalDate birthDate;
    private String condition;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(petName, pet.petName) && Objects.equals(petType, pet.petType) && Objects.equals(ownerId, pet.ownerId) && Objects.equals(birthDate, pet.birthDate) && Objects.equals(condition, pet.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), petName, petType, ownerId, birthDate, condition);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petName='" + petName + '\'' +
                ", petType='" + petType + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", birthDate=" + birthDate +
                ", condition='" + condition + '\'' +
                '}';
    }
}
