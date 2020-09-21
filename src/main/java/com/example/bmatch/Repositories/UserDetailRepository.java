package com.example.bmatch.Repositories;

import com.example.bmatch.Models.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail,Number> {
    Optional<UserDetail> findByUserNameAndUserLastname(String name,String lastname);

}
