package com.example.gamelistserver.Repository;

import com.example.gamelistserver.JPA.Game;
import com.example.gamelistserver.JPA.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query("SELECT g FROM Game g JOIN g.tags t WHERE t.name IN :tagNames GROUP BY g.id HAVING COUNT(DISTINCT t.name) = :tagCount")
    List<Game> findByAllTags(@Param("tagNames") List<String> tagNames, @Param("tagCount") long tagCount);

    List<Game> findAll();

    // Repository에 추가 (임시로)
    @Query("SELECT t FROM Tag t")
    List<Tag> findAllTags();

    // Repository에 추가
    @Query("SELECT g FROM Game g JOIN g.tags t WHERE t.name = :tagName")
    List<Game> findByOneTag(@Param("tagName") String tagName);

}
