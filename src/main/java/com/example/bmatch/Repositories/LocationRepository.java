package com.example.bmatch.Repositories;

import com.example.bmatch.Models.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<UserLocation,Number> {
}
