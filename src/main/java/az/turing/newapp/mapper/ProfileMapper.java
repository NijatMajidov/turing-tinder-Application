package az.turing.newapp.mapper;

import az.turing.newapp.entity.Profile;
import az.turing.newapp.model.request.ProfileDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper extends EntityMapper<Profile, ProfileDTO> {
}
