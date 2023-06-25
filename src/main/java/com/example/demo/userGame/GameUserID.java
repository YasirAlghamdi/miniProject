package com.example.demo.userGame;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@Embeddable
public class GameUserID implements Serializable {
    @Column(name = "game_id")
    int gameId;

    @Column(name = "user_id")
    int userId;
}
