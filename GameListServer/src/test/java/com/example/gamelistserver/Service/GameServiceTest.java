package com.example.gamelistserver.Service;

import com.example.gamelistserver.JPA.Game;
import com.example.gamelistserver.Repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private GameRepository gameRepository;
    private GameService gameService;

    @BeforeEach
    void setUp() {
        System.out.println("[TEST] Setting up mock repository and service...");
        gameRepository = mock(GameRepository.class); // Mockito로 가짜 객체 생성
        gameService = new GameService(gameRepository);
        System.out.println("[TEST] Setup complete.");
    }

    @Test
    void testSearchGamesByTags_ReturnsMatchingGames() {
        System.out.println("[TEST] Running test: testSearchGamesByTags_ReturnsMatchingGames");

        List<String> tags = Arrays.asList("RPG", "Adventure");
        System.out.println("[TEST] Given tags: " + tags);

        Game game1 = new Game();
        game1.setId(1);
        game1.setName("Fantasy World");

        List<Game> expectedGames = List.of(game1);

        // when: gameRepository가 호출되었을 때 어떤 값을 반환할지 지정
        when(gameRepository.findByAllTags(tags, tags.size())).thenReturn(expectedGames);
        System.out.println("[TEST] Mock repository configured to return expected games.");

        // then: 실제 서비스 메서드 실행 후 결과 검증
        List<Game> result = gameService.searchGamesByTags(tags);
        System.out.println("[TEST] Search result: " + result);

        assertEquals(1, result.size());
        assertEquals("Fantasy World", result.get(0).getName());
        System.out.println("[TEST] Assertion passed: Game name matches.");

        verify(gameRepository, times(1)).findByAllTags(tags, tags.size());
        System.out.println("[TEST] Verification passed: Repository method called once.");
    }
}
