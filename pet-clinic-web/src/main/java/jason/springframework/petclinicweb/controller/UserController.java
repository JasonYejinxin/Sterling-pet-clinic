package jason.springframework.petclinicweb.controller;

import jason.springframework.petclinicdata.model.User;
import jason.springframework.petclinicdata.repository.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private UserDao userDao;

    @GetMapping("/create")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "/user/registry";
    }

    @PostMapping("/create")
    public String registrySubmit(@ModelAttribute User user) {

        User newUser = new User();

        newUser.setUname(user.getUname());
        newUser.setPassword(user.getPassword());
        System.out.println("start");
        //userDao.save(user);
        userDao.insertRule(newUser.getUname(),newUser.getPassword());
        System.out.println(newUser);
        return "/user/success";
    }

    @GetMapping("/all")
    public String getMessage(Model model) {

        Iterable<User> user = userDao.findAll();

        model.addAttribute("user", user);
        return "/user/userList";
    }
}
