package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {



    @Query(value = "SELECT * FROM tweet where user_id = :id" , nativeQuery = true)
    List<Tweet> findAllByUserId(@Param("id") Long id);
    Tweet findFirstById(Long id);

    @Query(value = "SELECT * FROM tweet order by localDateTime desc limit :limit" ,nativeQuery = true)
    List<Tweet> findAllLimited(@Param("limit")Long limit);

}
