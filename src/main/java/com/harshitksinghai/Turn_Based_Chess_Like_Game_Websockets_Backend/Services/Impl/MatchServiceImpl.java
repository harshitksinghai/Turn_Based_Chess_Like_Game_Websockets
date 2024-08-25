package com.harshitksinghai.Turn_Based_Chess_Like_Game_Websockets_Backend.Services.Impl;

import com.harshitksinghai.Turn_Based_Chess_Like_Game_Websockets_Backend.Models.Match;
import com.harshitksinghai.Turn_Based_Chess_Like_Game_Websockets_Backend.Repositories.MatchRepository;
import com.harshitksinghai.Turn_Based_Chess_Like_Game_Websockets_Backend.Services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    MatchRepository matchRepository;
    @Override
    public String createMatch() {
        String matchCode = generateRandomMatchCode();
        String playerAId = generateRandomPlayerId();

        Match match = new Match();
        match.setMatchCode(matchCode);
        match.setPlayerAId(playerAId);
        match.setWaitingForPlayerB(true);

        matchRepository.save(match);

        return matchCode;
    }

    @Override
    public String joinMatch(String matchCode) {
        Match match = matchRepository.findByMatchCode(matchCode)
                .orElseThrow(() -> new RuntimeException("Match code not found"));

        if (!match.isWaitingForPlayerB()) {
            throw new RuntimeException("Match is not available for joining");
        }

        String playerBId = generateRandomPlayerId();
        match.setPlayerBId(playerBId);
        match.setWaitingForPlayerB(false);

        matchRepository.save(match);

        return playerBId;
    }

    private String generateRandomMatchCode() {
        return String.format("%06d", new Random().nextInt(999999));
    }

    private String generateRandomPlayerId() {
        return UUID.randomUUID().toString();
    }
}
