package hello.login.web.login;

import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {
    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
}

