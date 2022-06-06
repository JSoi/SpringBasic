package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String goLogin() {
        return "redirect:/login-form.html";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        String id = user.getId();
        String password = user.getPassword();
        if(id.equals(password)){
            model.addAttribute("loginId", id);
        }
        return "login-result";
    }
}
