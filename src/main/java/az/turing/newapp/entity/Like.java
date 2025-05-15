package az.turing.newapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Liker user must not be null")
    @ManyToOne
    @JoinColumn(name = "liker_id", nullable = false)
    private User liker;

    @NotNull(message = "Liked user must not be null")
    @ManyToOne
    @JoinColumn(name = "liked_id", nullable = false)
    private User liked;

    private boolean isLiked;
}
