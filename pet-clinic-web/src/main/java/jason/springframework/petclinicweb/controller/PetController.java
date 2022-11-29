package jason.springframework.petclinicweb.controller;

import jason.springframework.petclinicdata.repository.PetDao;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class PetController {
    @Resource
    private PetDao petDao;
}
