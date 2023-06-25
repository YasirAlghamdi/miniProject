package com.example.demo.game;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GameService {
    public List<Game> getGames();
    public Game getGameById(@PathVariable Long id);
    public void addGame(@RequestBody Game game) throws Exception;
    public void updateGame(@RequestBody Game game);
}
