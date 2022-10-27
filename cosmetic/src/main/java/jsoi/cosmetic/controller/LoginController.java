package jsoi.cosmetic.controller;

import jsoi.cosmetic.form.LoginForm;
import jsoi.cosmetic.entity.User;
import jsoi.cosmetic.repository.UserRepository;
import jsoi.cosmetic.service.LoginService;
import jsoi.cosmetic.validator.LoginValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class LoginController {
    public static final String MEMBER_ID = "memberId";
    private final LoginService loginService;
    private final LoginValidator loginValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(loginValidator);
    }

    @PostMapping("/login")
    public String loginProcess(@Validated @ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpServletResponse response) {
        // 바인딩 오류 검증
        if (bindingResult.hasErrors()) {
            return "error";
        }
        User loginUser = loginService.login(loginForm.getId(), loginForm.getPassword());
        if (loginUser == null) { // 로그인 실패
            return "false";
        }
        // 특정 정보가 들어가면 안 된다
        // response.addCookie(new Cookie("memberId", String.valueOf(loginForm.getId())));
        addCookie(response);
        return "true";
    }


    private void addCookie(HttpServletResponse response) {
        String sessionId = UUID.randomUUID().toString();
        response.addCookie(new Cookie(MEMBER_ID, sessionId));
    }
}
