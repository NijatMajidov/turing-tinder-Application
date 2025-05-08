package az.turing.newapp.service;

import az.turing.newapp.model.request.ProfileDTO;

import java.util.List;

public interface ProfileService {
    List<ProfileDTO> getAllProfiles();
    ProfileDTO getNextProfile(Long currentIndex);
}