package jsoi.cosmetic.form;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {
    @NotEmpty
    private String id;
    @NotEmpty
    private String password;
}
