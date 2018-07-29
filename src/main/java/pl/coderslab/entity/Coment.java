package pl.coderslab.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "coment")
public class Coment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 60)
    private String description;

    @ManyToOne
    Tweet tweet;

    @ManyToOne
    User user;

    public Coment(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
