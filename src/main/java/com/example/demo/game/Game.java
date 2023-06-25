package com.example.demo.game;

import com.example.demo.userGame.UserGame;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String developer;
    private String genre;
    private String platform;
    private int metacritic_score;
    private Date release_date;
    private int play_time;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserGame> userGames_games;

    public Game(String name, String developer, String genre, String platform, int metacritic_score, Date release_date, int play_time) {
        this.name = name;
        this.developer = developer;
        this.genre = genre;
        this.platform = platform;
        this.metacritic_score = metacritic_score;
        this.release_date = release_date;
        this.play_time = play_time;
    }
}
