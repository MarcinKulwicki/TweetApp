package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    @NotNull
    @NotBlank
    private String password;

    @Email
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    List<Tweet> tweets = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Coment> coments = new ArrayList<>();

    public User() {}

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Coment> getComents() {
        return coments;
    }

    public void setComents(List<Coment> coments) {
        this.coments = coments;
    }
}
