package com.harshitksinghai.Turn_Based_Chess_Like_Game_Websockets_Backend.Services;

public interface MatchService {
    String createMatch();

    String joinMatch(String matchCode);
}
