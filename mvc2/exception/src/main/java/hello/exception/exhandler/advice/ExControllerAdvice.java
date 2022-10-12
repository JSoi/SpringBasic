package hello.exception.exhandler.advice;

import hello.exception.api.ApiExceptionV2Controller;
import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
//@RestControllerAdvice(annotations = RestController.class) // 어노테이션이 붙은 클래스에만 지정
@RestControllerAdvice(basePackages = "hello.exception.api") // 패키지에 지정
//@RestControllerAdvice(assignableTypes = {ApiExceptionV2Controller.class}) // 클래스에 지정
public class ExControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 상태 코드 지정
    @ExceptionHandler(IllegalArgumentException.class) // Catch할 예외
    public ErrorResult illegalHandler(IllegalArgumentException e) {
        log.error("[ExceptionHandler] ex", e);
        return new ErrorResult("BAD", e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExHandler(UserException e) {
        log.error("[ExceptionHandler] ex", e);
        ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResult exHandler(Exception e) { // 커버되지 않은 예외들을 처리
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("EX", "내부 오류");
    }
}
