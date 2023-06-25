package com.example.demo.game;


import com.example.demo.game.gameHandler.GameRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService service;

    @Autowired
    public GameController(GameService gameService) {
        this.service = gameService;
    }

    @GetMapping
    ResponseEntity<GameRes> getGames() {
        try {
            List<Game> games =  service.getGames();
            return new ResponseEntity<>(new GameRes("Games are found", games), HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(new GameRes( e.getMessage() ), HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/{id}")
    ResponseEntity<GameRes> getGameById(@PathVariable Long id) {
        try {
            Game game = service.getGameById(id);
            return new ResponseEntity<>(new GameRes("The game is found", game), HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(new GameRes( e.getMessage() ), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    ResponseEntity<GameRes> addGame(@RequestBody Game game) {
        try {
            service.addGame(game);
            return new ResponseEntity<>(new GameRes("The game is added"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new GameRes( e.getMessage() ), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    ResponseEntity<GameRes> updateGame(@RequestBody Game game){
        try {
            service.updateGame(game);
            return new ResponseEntity<>(new GameRes("The game is updated"), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new GameRes( e.getMessage() ), HttpStatus.BAD_REQUEST);
        }
    }
}
