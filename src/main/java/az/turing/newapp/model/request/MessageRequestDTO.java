package az.turing.newapp.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessageRequestDTO {
    @NotNull(message = "Sender ID must not be null")
    private Long senderId;

    @NotNull(message = "Receiver ID must not be null")
    private Long receiverId;

    @NotBlank(message = "Message content must not be empty")
    private String content;
}
