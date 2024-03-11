package Module13;

import lombok.Data;

@Data
public class Comment {
    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;
}
