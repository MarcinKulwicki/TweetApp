package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String login(){
        return "login";
    }
    @PostMapping("")
    public String login(HttpServletRequest request){

        if(userService.checkLogin(request.getParameter("username"), request.getParameter("password"))){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("UserLogged", userService.checkLogin(request.getParameter("username"), request.getParameter("password")) );
            return "redirect:/user";
        }

        return "login";

    }

}
