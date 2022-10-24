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

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final  UserRepository userRepository;
    private final LoginValidator loginValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(loginValidator);
    }

    @PostMapping("/login")
    public String loginProcess(@Validated @ModelAttribute LoginForm loginForm, BindingResult bindingResult){
        // 바인딩 오류 검증
        if (bindingResult.hasErrors()) {
            return "error";
        }
        User loginUser = loginService.login(loginForm.getId(), loginForm.getPassword());
        if (loginUser == null) {
            return "false";
        }
        return "true";
    }
}
