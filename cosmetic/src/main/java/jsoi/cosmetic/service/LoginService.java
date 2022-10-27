package jsoi.cosmetic.service;

import jsoi.cosmetic.entity.User;
import jsoi.cosmetic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;

    public User login(String id, String password) {
        return userRepository.findUserByUserId(id)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }
}
