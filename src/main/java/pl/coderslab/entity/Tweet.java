package pl.coderslab.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 140, min = 1)
    private String tweet;

    private LocalDateTime localDateTime;

    @ManyToOne
    private User user;

    public Tweet(){
        setLocalDateTime();
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    private void setLocalDateTime() {
        this.localDateTime = LocalDateTime.now();
    }
}
