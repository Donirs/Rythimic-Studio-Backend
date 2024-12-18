package rythmic.ryhtmic_studio_backend.repository;

import rythmic.ryhtmic_studio_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);

    Optional<User> findFirstByEmail(String email);

    Optional<User> findFirstByToken(String token);

    Optional<User> findFirstByOtp(String otp);

    Optional<User> findFirstByResetToken(String resetToken);
}
