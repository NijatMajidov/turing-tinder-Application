package az.turing.newapp.model.response;

import az.turing.newapp.entity.User;
import lombok.Data;

@Data
public class LikeResponseDTO {
    private Long id;
    private User liker;
    private User liked;
    private boolean isLiked;
}
