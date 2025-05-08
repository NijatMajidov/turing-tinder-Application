package az.turing.newapp.controller;

import az.turing.newapp.model.request.ProfileDTO;
import az.turing.newapp.service.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // GET /users → bütün profilləri qaytar
    @GetMapping
    public List<ProfileDTO> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    // GET /users/next/{index} → növbəti profili qaytar
    @GetMapping("/next/{index}")
    public ProfileDTO getNextProfile(@PathVariable Long index) {
        return profileService.getNextProfile(index);
    }
}