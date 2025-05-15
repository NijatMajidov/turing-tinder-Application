package az.turing.newapp.mapper;

import az.turing.newapp.entity.Like;
import az.turing.newapp.entity.User;
import az.turing.newapp.model.request.LikeRequestDTO;
import az.turing.newapp.model.response.LikeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface LikeMapper extends EntityMapper<Like, LikeRequestDTO, LikeResponseDTO> {

    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    @Mapping(target = "liker", source = "liker", qualifiedByName = "mapToUser")
    @Mapping(target = "liked", source = "liked", qualifiedByName = "mapToUser")
    Like toEntity(LikeRequestDTO dto);

    @Mapping(target = "liker", source = "liker.id")
    @Mapping(target = "liked", source = "liked.id")
    LikeResponseDTO toDto(Like entity);

    @Named("mapToUser")
    default User mapToUser(Long id) {
        if (id == null) return null;
        User user = new User();
        user.setId(id);
        return user;
    }
}
