package com.example.gamelistserver.Service;

import com.example.gamelistserver.JPA.Game;
import com.example.gamelistserver.Repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> searchGamesByTags(List<String> tagNames) {
        return gameRepository.findByAllTags(tagNames, tagNames.size());
    }
}