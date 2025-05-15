package az.turing.newapp.model.request;

import az.turing.newapp.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LikeRequestDTO {
    @NotNull(message = "Liker ID must not be null")
    private User liker;

    @NotNull(message = "Liked ID must not be null")
    private User liked;

    private boolean isLiked;
}
