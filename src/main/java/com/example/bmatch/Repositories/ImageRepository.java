package com.example.bmatch.Repositories;

import com.example.bmatch.Models.Image;
import com.example.bmatch.Models.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Number> {
}
