package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Coment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.ComentRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/coment")
public class ComentController {

    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    ComentRepository comentRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public String coment(@PathVariable Long id, Model model){

        model.addAttribute("tweets", tweetRepository.findFirstById(id));
        model.addAttribute("coments", comentRepository.findAllByTweetId(id));
        model.addAttribute("coment", new Coment());
        return "comentView";
    }
    @PostMapping("/{id}")
    public String coment(@Valid Coment coment, BindingResult bindingResult, HttpServletRequest request, @PathVariable Long id,Model model){

        if(!bindingResult.hasErrors()){
            HttpSession sess = request.getSession();
            User user = (User)sess.getAttribute("UserLogged");
            if(user != null){
                coment.setUser(user);
                coment.setTweet(tweetRepository.findFirstById(id));
                comentRepository.save(coment);
            }else {
                model.addAttribute("notlogged", true);
            }
        }

        return "redirect:/coment/{id}";
    }
}
