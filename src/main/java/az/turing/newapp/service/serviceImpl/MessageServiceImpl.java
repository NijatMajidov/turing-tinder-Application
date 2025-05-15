package az.turing.newapp.service.serviceImpl;

import az.turing.newapp.entity.Message;
import az.turing.newapp.mapper.MessageMapper;
import az.turing.newapp.model.request.MessageRequestDTO;
import az.turing.newapp.model.response.MessageResponseDTO;
import az.turing.newapp.repository.LikeRepository;
import az.turing.newapp.repository.MessageRepository;
import az.turing.newapp.service.MessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final LikeRepository likeRepository;

    public MessageServiceImpl(MessageRepository messageRepository, MessageMapper messageMapper, LikeRepository likeRepository) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
        this.likeRepository = likeRepository;
    }

    @Override
    public MessageResponseDTO sendMessage(MessageRequestDTO dto) {
        boolean isLiked = likeRepository.existsByLikerIdAndLikedId(dto.getReceiverId(), dto.getSenderId());
        if (!isLiked) {
            throw new RuntimeException("You can only message users who have liked you back.");
        }

        Message message = messageMapper.toEntity(dto);
        message.setTimestamp(LocalDateTime.now());

        return messageMapper.toDto(messageRepository.save(message));
    }

    @Override
    public List<MessageResponseDTO> getAllMessages() {
        return messageRepository.findAll()
                .stream()
                .map(messageMapper::toDto)
                .toList();
    }

    @Override
    public List<MessageResponseDTO> getMessagesBetweenUsers(Long senderId, Long receiverId) {
        return messageRepository.findBySenderIdAndReceiverId(senderId, receiverId)
                .stream()
                .map(messageMapper::toDto)
                .toList();
    }
}