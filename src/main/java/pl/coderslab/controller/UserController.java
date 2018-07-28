package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("user", userRepository.findAll());
        return "user/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "user/form";
    }
    @PostMapping("/add")
    public String add(@Valid User user, BindingResult bindingResult){
        if(!bindingResult.hasErrors()) userService.addUser(user);
        return "redirect:/user";
    }
    @GetMapping("/add/{id}")
    public String edit(Model model, @PathVariable Long id){
        User user = userRepository.findFirstById(id);
        String password = "";
        if( BCrypt.checkpw("salat" ,user.getPassword())) password="salat";
        model.addAttribute("pass", password);
        model.addAttribute("user", user);
        return "user/form";
    }
//    @PostMapping("/add/{id}")
//    public String edit(@Valid User user, BindingResult bindingResult){
//        if(!bindingResult.hasErrors()) userService.editUser(user);
//        return "redirect:/user";
//    }

}
