package guevara.demo.controller;

import guevara.demo.model.Role;
import guevara.demo.model.User;
import guevara.demo.repository.RoleRepository;
import guevara.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/")
    public String index()
    {
        return"indexx";
    }
    @RequestMapping("/login")
    public String logon(){
        return"login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/secure")
    public String secure(){
        return "secure";
    }


    @RequestMapping("/register")

    public String signUp( Model model){
        User newuser=new User();
        model.addAttribute("newuser", newuser);
        Iterable<Role>test= roleRepository.findAllById(new Long(1));
        for(Role item : test)
        {
            System.out.println(item.getRole());
        }
        return"register";
    }
    @PostMapping("/register")
    public String proccessNew(@ModelAttribute("newuser") User otheruser){

        otheruser.setEnabled(true);


        Role newrole=roleRepository.findByRole("USER");

        otheruser.addRole(newrole);


        userRepository.save(otheruser);


        return"popnew";
    }
}
