package ru.banki.mpk.javaweekly.springsecurityexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.banki.mpk.javaweekly.springsecurityexample.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
