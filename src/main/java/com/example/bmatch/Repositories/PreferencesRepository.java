package com.example.bmatch.Repositories;

import com.example.bmatch.Models.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends JpaRepository<Preferences,Number> {

}