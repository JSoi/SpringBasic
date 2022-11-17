package jsoi.cosmetic.service;

import jsoi.cosmetic.entity.User;
import jsoi.cosmetic.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {
    @InjectMocks
    LoginService loginService;

    @Mock
    UserRepository userRepository;

    private User user;

    @BeforeEach
    public void initializeUsers() {
        user = new User(null, "test", "testId", "testpassword", null, null);
    }

    @Test
    public void loginSuccess() {
        //given
        when(userRepository.findUserByUserId("testId")).thenReturn(Optional.of(user));
        //when
        User loginTrialUser = loginService.login("testId", "testpassword");
        //then
        Assertions.assertThat(loginTrialUser).isEqualTo(user);
    }


}