package az.turing.newapp.mapper;

import az.turing.newapp.entity.Message;
import az.turing.newapp.model.request.MessageRequestDTO;
import az.turing.newapp.model.response.MessageResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper extends EntityMapper<Message, MessageRequestDTO, MessageResponseDTO> {
}
