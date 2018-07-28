package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.TweetService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    TweetService tweetService;
    @Autowired
    UserRepository userRepository;


    @GetMapping("/list")
    public String listAll(Model model){
        model.addAttribute("tweets", tweetRepository.findAll());
        return "tweet/list";
    }
    @GetMapping("/list/user")
    public String listUser(Model model, HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("UserLogged");
        model.addAttribute("tweets", tweetRepository.findAllByUserId(user.getId()));
        return "tweet/list";
    }
    @GetMapping("/list/user/add")
    public String add(Model model){
        model.addAttribute("tweets", new Tweet());
        return "tweet/form";
    }
    @PostMapping("/list/user/add")
    public String add(@Valid Tweet tweet, BindingResult bindingResult, HttpServletRequest request){
        if(!bindingResult.hasErrors()) tweetService.saveTweetByUserInSession(request, tweet);
        return "redirect:/tweet/list/user";
    }
    @GetMapping("/list/user/add/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("tweets", tweetRepository.findFirstById(id));
        return "tweet/form";
    }
    @PostMapping("/list/user/add/{id}")
    public String edit(@Valid Tweet tweet, BindingResult bindingResult, HttpServletRequest request){
        if(!bindingResult.hasErrors()) tweetService.saveTweetByUserInSession(request, tweet);
        return "redirect:/tweet/list/user";
    }


}
