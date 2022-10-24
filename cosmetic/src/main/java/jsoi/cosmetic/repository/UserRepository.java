package jsoi.cosmetic.repository;

import jsoi.cosmetic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserId(String id);

    Optional<User> findUserByUserIdAndPassword(String userId, String password);
}
