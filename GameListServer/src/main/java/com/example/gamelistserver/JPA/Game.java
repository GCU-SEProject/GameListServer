package com.example.gamelistserver.JPA;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 255)
    private String company;

    @Column(length = 500)
    private String link;

    private Integer ageRating;

    private Integer price;

    private LocalDate releaseDate;

    @Column(length = 500)
    private String description;


    @ManyToMany
    @JoinTable(
            name = "game_tag",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    // Getters, Setters, Constructors
    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", link='" + link + '\'' +
                ", ageRating=" + ageRating +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", description='" + description + '\'' +
                '}';
    }
}
