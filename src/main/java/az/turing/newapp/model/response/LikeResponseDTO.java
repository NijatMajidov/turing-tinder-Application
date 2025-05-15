package az.turing.newapp.model.response;

import lombok.Data;

@Data
public class LikeResponseDTO {
    private Long id;
    private Long liker;
    private Long liked;
    private boolean isLiked;
}