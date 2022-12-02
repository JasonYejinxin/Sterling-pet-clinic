package jason.springframework.petclinicweb.controller;

import jason.springframework.petclinicdata.model.Owner;
import jason.springframework.petclinicdata.model.User;
import jason.springframework.petclinicdata.service.OwnerService;
import org.springframework.stereotype.Controller;
import jason.springframework.petclinicdata.repository.OwnerDao;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OwnerController {

    @Resource
    private OwnerService ownerService;



    @GetMapping("/ownerRegister")
    public String registerOwner(Model model) {
        model.addAttribute("owner", new Owner());
        return "/owner/welcome";
    }

    @PostMapping("/ownerRegister")
    public String registrySubmit(@ModelAttribute Owner owner) {
   int conditionNum = ownerService.registService(owner);
        if(conditionNum == 2){
            return "/owner/success";
        }
        else if(conditionNum == 1){
            return "/owner/fail";
        }
        else if(conditionNum == 0){
            return "/owner/emailError";
        }
        else return "/index/error";
    }

    @GetMapping("/ownerLogin")
    public String loginOwner(Model model){
        model.addAttribute("owner",new Owner());
        return "/owner/login";
    }


//    @PostMapping("/ownerLogin")
//    public String loginSubmit(@ModelAttribute Owner owner){
////        Owner owner1 = new Owner();
////        owner1.setUname(owner.getUname());
////        owner1.setPassword(owner.getPassword());
//       // Owner newOwner = ownerService.loginService(owner1.getUname(),owner1.getPassword());
//        Owner newOwner = ownerDao.findByUnameAndPassword(owner.getUname(),owner.getPassword());
//        //List<Owner> newOwner = ownerDao.findOwnerByUnameAndPassword(owner.getUname(),owner.getPassword());
//        if(newOwner.getUname() != null){
//            return "/owner/ownerList";
//        }
//        else {
//            return "/owner/fail";
//        }
//    }

}
