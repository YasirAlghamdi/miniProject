package com.example.demo.user;

import com.example.demo.game.Game;
import com.example.demo.userGame.UserGame;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user_name;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserGame> userGames;
}
