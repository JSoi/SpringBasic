package jsoi.cosmetic.form;

import jsoi.cosmetic.entity.Comment;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
/**
 * 계층간에 데이터를 전송할 때 사용하지만, 컨트롤러까지만 사용한다는 제약
 */
public class CommentSaveForm {
    @Range(min = 0, max = 5)
    private int star;
    @NotEmpty
    private String content;

    public Comment toEntity() {
        return Comment.builder()
                .star(star)
                .content(content)
                .build();
    }
}
