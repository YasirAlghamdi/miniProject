package com.example.demo.game;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GAME")
public class Game {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String developer;
    private String genre;
    private String platform;
    private String metacritic_score;
    private Date release_date;
    private String play_time;
}
