package jsoi.cosmetic.form;

import jsoi.cosmetic.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 계층간에 데이터를 전송할 때 사용하지만, 컨트롤러까지만 사용한다는 제약
 */
public class CommentUpdateForm {
    private Long userId;
    private int star;
    private String content;
}
