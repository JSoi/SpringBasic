package jsoi.cosmetic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "잘못된 요청 오류")
public class CustomException extends RuntimeException {
    public CustomException() {
        super("Custom Exception");
    }
}
