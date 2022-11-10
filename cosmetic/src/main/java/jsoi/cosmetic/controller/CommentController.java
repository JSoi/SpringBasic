package jsoi.cosmetic.controller;

import jsoi.cosmetic.form.CommentSaveForm;
import jsoi.cosmetic.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody CommentSaveForm commentSaveForm) {
        commentService.addNewComment(commentSaveForm);
        return new ResponseEntity<>("평가 등록 성공", HttpStatus.ACCEPTED);
    }
}
