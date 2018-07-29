package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Coment;

import java.util.List;

public interface ComentRepository extends JpaRepository<Coment , Long> {
    Coment findFirstById(Long id);
    List<Coment> findAllByTweetId(Long id);
}
