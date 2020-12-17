package com.example.bmatch.Repositories;

import com.example.bmatch.Models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match,Number> {
    Optional<Match> findByLikedIdAndLikerId(int likerId,int likedId);
}
