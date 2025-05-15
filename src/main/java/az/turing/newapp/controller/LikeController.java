package az.turing.newapp.controller;

import az.turing.newapp.model.request.LikeRequestDTO;
import az.turing.newapp.model.response.LikeResponseDTO;
import az.turing.newapp.service.LikeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<LikeResponseDTO> likeUser(@Valid @RequestBody LikeRequestDTO dto) {
        return ResponseEntity.ok(likeService.likeUser(dto));
    }

    @GetMapping
    public ResponseEntity<List<LikeResponseDTO>> getAllLikes() {
        return ResponseEntity.ok(likeService.getAllLikes());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LikeResponseDTO>> getLikesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(likeService.getLikesByUser(userId));
    }
}
