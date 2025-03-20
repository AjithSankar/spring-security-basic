package dev.ak.springsecurity.repository;

import dev.ak.springsecurity.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

    UserAuth findByUsername(String username);
}
