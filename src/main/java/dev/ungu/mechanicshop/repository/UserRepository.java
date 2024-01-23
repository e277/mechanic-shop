package dev.ungu.mechanicshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ungu.mechanicshop.model.Role;
import dev.ungu.mechanicshop.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    User findByRole(Role role);
}
