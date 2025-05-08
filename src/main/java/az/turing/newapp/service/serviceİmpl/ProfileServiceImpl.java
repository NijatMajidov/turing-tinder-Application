package az.turing.newapp.service.serviceİmpl;

import az.turing.newapp.entity.Profile;
import az.turing.newapp.mapper.ProfileMapper;
import az.turing.newapp.model.request.ProfileDTO;
import az.turing.newapp.repository.ProfileRepository;
import az.turing.newapp.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public ProfileServiceImpl(ProfileRepository profileRepository, ProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
    }

    @Override
    public List<ProfileDTO> getAllProfiles() {
        List<Profile> profiles = profileRepository.findAll();
        return profiles.stream()
                .map(profileMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProfileDTO getNextProfile(Long currentIndex) {
        List<Profile> profiles = profileRepository.findAll();
        if (profiles.isEmpty()) return null;

        int nextIndex = (int) ((currentIndex + 1) % profiles.size());
        return profileMapper.toDto(profiles.get(nextIndex));
    }
}