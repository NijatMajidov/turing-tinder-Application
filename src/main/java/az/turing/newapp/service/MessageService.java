package az.turing.newapp.service;

import az.turing.newapp.model.request.MessageRequestDTO;
import az.turing.newapp.model.response.MessageResponseDTO;

import java.util.List;

public interface MessageService {
    MessageResponseDTO sendMessage(MessageRequestDTO dto);

    List<MessageResponseDTO> getAllMessages();

    List<MessageResponseDTO> getMessagesBetweenUsers(Long senderId, Long receiverId);
}