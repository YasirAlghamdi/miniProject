package com.example.demo.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GameServiceImp implements GameService{

    private final GameRepository repo;

    @Autowired
    public GameServiceImp(GameRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Game> getGames() {
        List<Game> games = repo.findAll();
        if(games.isEmpty())
            throw new NoSuchElementException("There is NO game!");
        return games;
    }

    @Override
    public Game getGameById(Long id) {
        Optional<Game> game = repo.findById(id);
        if (game.isPresent())
            return game.get();
        throw new NoSuchElementException("The game is NOT exist!");
    }

    @Override
    public void addGame(Game game) throws Exception {
        Optional<Game> _game = repo.findById(game.getId());
        if (_game.isPresent())
            throw new Exception("The "+_game.get().getName().toLowerCase()+" game is already exist!");
        repo.save(game);
    }

    @Override
    public void updateGame(Game game) throws NoSuchElementException {
        Optional<Game> _game = repo.findById(game.getId());
        if(_game.isPresent()){
            _game.get().setName(game.getName());
            _game.get().setDeveloper(game.getDeveloper());
            _game.get().setGenre(game.getGenre());
            _game.get().setPlatform(game.getPlatform());
            _game.get().setMetacritic_score(game.getMetacritic_score());
            _game.get().setRelease_date(game.getRelease_date());
            _game.get().setPlay_time(game.getPlay_time());
            repo.save(_game.get());
        }
        else
            throw new NoSuchElementException("The game is NOT exist!");
    }
}
