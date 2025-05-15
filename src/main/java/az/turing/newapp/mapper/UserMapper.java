package az.turing.newapp.mapper;

import az.turing.newapp.entity.User;
import az.turing.newapp.model.request.UserRequestDTO;
import az.turing.newapp.model.response.UserResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<User, UserRequestDTO, UserResponseDTO> {
}
