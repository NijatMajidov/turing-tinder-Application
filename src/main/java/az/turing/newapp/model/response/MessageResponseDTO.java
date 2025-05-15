package az.turing.newapp.model.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageResponseDTO {
    private Long id;
    private String content;
    private String senderUsername;
    private String receiverUsername;
    private LocalDateTime timestamp;
}
