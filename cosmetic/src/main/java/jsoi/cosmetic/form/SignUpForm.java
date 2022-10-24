package jsoi.cosmetic.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SignUpForm {
    @NotEmpty
    private String name;

    @NotEmpty
    private String userId;

    @NotEmpty
    private String password;
}
