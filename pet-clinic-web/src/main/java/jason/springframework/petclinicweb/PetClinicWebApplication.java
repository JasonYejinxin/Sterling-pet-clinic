package jason.springframework.petclinicweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("jason.springframework.petclinicdata.repository")
@EntityScan("jason.springframework.petclinicdata.model")
@ComponentScan("jason.springframework")
public class PetClinicWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicWebApplication.class, args);
    }
}
