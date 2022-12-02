package jason.springframework.petclinicdata.service.serviceImpl;

import jason.springframework.petclinicdata.model.Vet;
import jason.springframework.petclinicdata.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceImpl implements VetService {
    @Override
    public Vet loginService(String email, String password) {
        return null;
    }

    @Override
    public int registService(Vet vet) {
        return 0;
    }
}
