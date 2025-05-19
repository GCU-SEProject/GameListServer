package com.example.gamelistserver.JPA;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;
    // Getters, Setters, Constructors
    @Override
    public String toString() {
        return "Tag{id=" + id + ", name='" + name + "'}";
    }

}
