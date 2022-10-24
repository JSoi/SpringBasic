package jsoi.cosmetic;

import jsoi.cosmetic.entity.User;
import jsoi.cosmetic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final UserRepository userRepository;

    @PostConstruct
    public void addUser() {
        User user = new User(null, "hi", "hi1234", "1234", null, null);
        userRepository.save(user);
    }
}
