package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public String login(){
        return "login";
    }
    @PostMapping("")
    public String login(HttpServletRequest request){

        if(userService.checkLogin(request.getParameter("username"), request.getParameter("password"))){
            HttpSession httpSession = request.getSession();
            if(userService.checkLogin(request.getParameter("username"), request.getParameter("password"))){
                User user = userRepository.findByUsername(request.getParameter("username"));
                httpSession.setAttribute("UserLogged",  user);
                httpSession.setAttribute("Logged", true);
            }
            return "redirect:/user/list";
        }

        return "login";

    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "user/form";
    }
    @PostMapping("/add")
    public String add(@Valid User user, BindingResult bindingResult){
        if(!bindingResult.hasErrors()) userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/forgotPassword")
    public String forgot(Model model){
        model.addAttribute("forgotPassword", true);
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/forgotPassword")
    public String forgot(@ModelAttribute User user, HttpServletRequest request){

        userService.changePasswordIfCorrect(user, request);
        return "redirect:/login";
    }

}
