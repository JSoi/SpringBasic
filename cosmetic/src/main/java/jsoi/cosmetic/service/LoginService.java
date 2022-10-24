package jsoi.cosmetic.service;

import jsoi.cosmetic.entity.User;
import jsoi.cosmetic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;

    public User login(String id, String password) {
        return userRepository.findUserByUserIdAndPassword(id, password).orElse(null);
    }
}
