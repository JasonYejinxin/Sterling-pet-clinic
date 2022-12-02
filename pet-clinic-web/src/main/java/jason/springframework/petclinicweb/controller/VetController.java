package jason.springframework.petclinicweb.controller;

import jason.springframework.petclinicdata.model.Vet;
import jason.springframework.petclinicdata.repository.VetDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class VetController {
    @Resource
    private VetDao vetDao;

    @GetMapping("/vetRegister")
    public String registerVet(Model model) {
        model.addAttribute("vet", new Vet());
        return "/vet/welcome";
    }

    @PostMapping("/vetRegister")
    public String registrySubmit(@ModelAttribute Vet vet) {
        Vet newVet = new Vet();
        newVet.setEmail(vet.getEmail());
        newVet.setPassword(vet.getPassword());
        newVet.setSpecialties(vet.getSpecialties());
        newVet.setStartOfCareer(vet.getStartOfCareer());
        vetDao.insertVet(newVet.getEmail(), newVet.getPassword(), newVet.getSpecialties(), newVet.getStartOfCareer());
        return "/vet/success";
    }

    @GetMapping("/vetLogin")
    public String loginOwner(Model model){
        model.addAttribute("vet",new Vet());
        return "/vet/login";
    }


    @PostMapping("/vetLogin")
    public String loginSubmit(@ModelAttribute Vet vet){
        List<Vet> newVet = vetDao.findVetByUnameAndPassword(vet.getEmail(),vet.getPassword());
        if(newVet.get(0) != null){
            return "/vet/vetList";
        }
        else {
            return "/vet/fail";
        }
    }
}
