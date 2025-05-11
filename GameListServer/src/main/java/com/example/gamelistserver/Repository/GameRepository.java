package com.example.gamelistserver.Repository;

import com.example.gamelistserver.JPA.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query("SELECT g FROM Game g JOIN g.tags t WHERE t.name IN :tagNames GROUP BY g.id HAVING COUNT(DISTINCT t.name) = :tagCount")
    List<Game> findByAllTags(@Param("tagNames") List<String> tagNames, @Param("tagCount") long tagCount);
}
