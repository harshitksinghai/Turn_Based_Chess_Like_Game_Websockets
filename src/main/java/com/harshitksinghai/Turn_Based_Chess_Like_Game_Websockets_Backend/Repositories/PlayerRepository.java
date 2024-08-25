package com.harshitksinghai.Turn_Based_Chess_Like_Game_Websockets_Backend.Repositories;

import com.harshitksinghai.Turn_Based_Chess_Like_Game_Websockets_Backend.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByPlayerId(String playerId);
}
