package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/list")
    public String list(Model model, HttpServletRequest request){
        model.addAttribute("wrongPassword" , request.getParameter("wrongPassword"));

        HttpSession sess = request.getSession();
        User user = (User) sess.getAttribute("UserLogged");
        if( user.getUsername().equals("admin")){
            model.addAttribute("user", userRepository.findAll());
        }else {
            List<User> users = new ArrayList<>();
            users.add(userRepository.findFirstById(user.getId()));
            model.addAttribute("user", users);
        }
        return "user/list";
    }
    @GetMapping("/add/{id}")
    public String edit(Model model, @PathVariable Long id){
        model.addAttribute("user", userRepository.findFirstById(id));
        return "user/form";
    }
    @PostMapping("/add/{id}")
    public String edit(@Valid User user, BindingResult bindingResult, Model model){
        if(!bindingResult.hasErrors()){
            if(BCrypt.checkpw(user.getPassword(),userRepository.findFirstById(user.getId()).getPassword())) userService.addUser(user);
            else model.addAttribute("wrongPassword", true);
        }
        return "redirect:/user/list";
    }
//    @PostMapping("/add/{id}")
//    public String edit(@Valid User user, BindingResult bindingResult){
//        if(!bindingResult.hasErrors()) userService.editUser(user);
//        return "redirect:/user";
//    }

}
