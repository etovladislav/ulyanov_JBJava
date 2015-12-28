package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.model.Post;
import ru.kpfu.itis.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Long removeById(Long id);

    List<Post> findByUserOrderByDateDesc(User user);

    @Transactional
    @Modifying
    @Query(value = "delete from Post p where p.id = :id")
    void delete(@Param("id") Long id);
}
