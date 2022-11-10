package jsoi.cosmetic.service;

import jsoi.cosmetic.entity.Comment;
import jsoi.cosmetic.form.CommentSaveForm;
import jsoi.cosmetic.form.CommentUpdateForm;
import jsoi.cosmetic.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void addNewComment(CommentSaveForm commentSaveForm) {
        commentRepository.save(commentSaveForm.toEntity());
    }

    public void updateComment(CommentUpdateForm commentUpdateForm) {
        Comment targetComment = commentRepository.findById(commentUpdateForm.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다"));
        targetComment.updateComment(commentUpdateForm);
    }
}
