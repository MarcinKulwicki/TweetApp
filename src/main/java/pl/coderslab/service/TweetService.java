package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Component
public class TweetService {

    @Autowired
    TweetRepository tweetRepository;

    public void saveTweetByUserInSession(HttpServletRequest request, Tweet tweet){

        HttpSession sess = request.getSession();
        User user = (User) sess.getAttribute("UserLogged");
        tweet.setUser(user);
        tweetRepository.save(tweet);
    }
}
