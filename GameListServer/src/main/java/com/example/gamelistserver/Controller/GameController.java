package com.example.gamelistserver.Controller;

import com.example.gamelistserver.JPA.Game;
import com.example.gamelistserver.Service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game")
    public List<Game> getGamesByTags(@RequestParam List<String> tag) {
        return gameService.searchGamesByTags(tag);
    }
}