package com.harshitksinghai.Turn_Based_Chess_Like_Game_Websockets_Backend.Controllers;

import com.harshitksinghai.Turn_Based_Chess_Like_Game_Websockets_Backend.Services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/create")
    public ResponseEntity<String> createMatch() {
        String matchCode = matchService.createMatch();
        return ResponseEntity.ok(matchCode);
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinMatch(@RequestParam String matchCode) {
        String playerId = matchService.joinMatch(matchCode);
        return ResponseEntity.ok(playerId);
    }
}
