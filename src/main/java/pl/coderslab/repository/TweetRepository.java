package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {


    @Query("select t from Tweet t where t.user.id = :id order by t.localDateTime desc")
    List<Tweet> findAllByUserId(@Param("id") Long id);

    List<Tweet> findAllByUserOrOrderByLocalDateTimeDesc(User user);
}
