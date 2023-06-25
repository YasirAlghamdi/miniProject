package com.example.demo.user;

import com.example.demo.game.Game;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GAME")
public class user {
    @Id
    @GeneratedValue
    private Long id;
    private String user_name;
    private String name;
    private String email;
    private String password;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "userGame",
    joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "game_id", referencedColumnName = "id")
    })
    private List<Game> games;
}
