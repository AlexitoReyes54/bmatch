package com.example.bmatch.Repositories;

import com.example.bmatch.Models.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Preferences,Number> {
}
