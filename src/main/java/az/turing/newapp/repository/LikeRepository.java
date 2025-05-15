package az.turing.newapp.repository;

import az.turing.newapp.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByLikerIdAndLikedId(Long likerId, Long likedId);
    Like findByLikerIdAndLikedId(Long likerId, Long likedId);
    List<Like> findByLikerId(Long likedId);
}
