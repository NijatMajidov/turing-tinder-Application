package az.turing.newapp.repository;

import az.turing.newapp.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
