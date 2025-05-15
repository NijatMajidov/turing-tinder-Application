package az.turing.newapp.controller;

import az.turing.newapp.model.request.MessageRequestDTO;
import az.turing.newapp.model.response.MessageResponseDTO;
import az.turing.newapp.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<MessageResponseDTO> sendMessage(@Valid @RequestBody MessageRequestDTO dto) {
        return ResponseEntity.ok(messageService.sendMessage(dto));
    }

    @GetMapping
    public ResponseEntity<List<MessageResponseDTO>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @GetMapping("/between")
    public ResponseEntity<List<MessageResponseDTO>> getMessagesBetweenUsers(@RequestParam Long senderId, @RequestParam Long receiverId) {
        return ResponseEntity.ok(messageService.getMessagesBetweenUsers(senderId, receiverId));
    }
}