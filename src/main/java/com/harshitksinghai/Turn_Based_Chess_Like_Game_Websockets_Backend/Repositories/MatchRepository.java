package com.harshitksinghai.Turn_Based_Chess_Like_Game_Websockets_Backend.Repositories;

import com.harshitksinghai.Turn_Based_Chess_Like_Game_Websockets_Backend.Models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    Optional<Match> findByMatchCode(String matchCode);
}
