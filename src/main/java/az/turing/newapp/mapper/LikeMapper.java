package az.turing.newapp.mapper;

import az.turing.newapp.entity.Like;
import az.turing.newapp.model.request.LikeRequestDTO;
import az.turing.newapp.model.response.LikeResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LikeMapper extends EntityMapper<Like, LikeRequestDTO, LikeResponseDTO> {
}
