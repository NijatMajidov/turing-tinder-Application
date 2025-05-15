package az.turing.newapp.service;

import az.turing.newapp.model.request.LikeRequestDTO;
import az.turing.newapp.model.response.LikeResponseDTO;

import java.util.List;

public interface LikeService {
    LikeResponseDTO likeUser(LikeRequestDTO dto);
    List<LikeResponseDTO> getAllLikes();
    List<LikeResponseDTO> getLikesByUser(Long userId);
}