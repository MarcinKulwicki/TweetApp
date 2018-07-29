package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public String showTweets(Model model){

        List<Tweet> tweets = tweetRepository.findAllLimited(20L);
        List<User> users = new ArrayList<>();
        for(Tweet tweet:tweets){
            users.add(userRepository.findFirstById(tweet.getUser().getId()));
        }
        Collections.reverse(users);
        model.addAttribute("user", users);
        model.addAttribute("tweets", tweets);
        return "main";
    }

}
