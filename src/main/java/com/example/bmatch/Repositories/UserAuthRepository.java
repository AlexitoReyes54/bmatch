package com.example.bmatch.Repositories;

import com.example.bmatch.Models.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth,Number> {
    Optional<UserAuth> findByEmail(String email);

}
