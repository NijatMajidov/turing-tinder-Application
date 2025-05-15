package az.turing.newapp.service.serviceImpl;

import az.turing.newapp.entity.Like;
import az.turing.newapp.mapper.LikeMapper;
import az.turing.newapp.model.request.LikeRequestDTO;
import az.turing.newapp.model.response.LikeResponseDTO;
import az.turing.newapp.repository.LikeRepository;
import az.turing.newapp.service.LikeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final LikeMapper likeMapper;

    public LikeServiceImpl(LikeRepository likeRepository, LikeMapper likeMapper) {
        this.likeRepository = likeRepository;
        this.likeMapper = likeMapper;
    }

    @Override
    public LikeResponseDTO likeUser(LikeRequestDTO dto) {
        // Mövcud like varsa onu yenilə
        Like existingLike = likeRepository.findByLikerIdAndLikedId(dto.getLiker(), dto.getLiked());

        if (existingLike != null) {
            //existingLike.setLiked(dto.isLiked());
            return likeMapper.toDto(likeRepository.save(existingLike));
        }

        Like like = likeMapper.toEntity(dto);
        return likeMapper.toDto(likeRepository.save(like));
    }

    @Override
    public List<LikeResponseDTO> getAllLikes() {
        return likeRepository.findAll()
                .stream()
                .map(likeMapper::toDto)
                .toList();
    }

    @Override
    public List<LikeResponseDTO> getLikesByUser(Long userId) {
        return likeRepository.findByLikerId(userId)
                .stream()
                .map(likeMapper::toDto)
                .toList();
    }
}