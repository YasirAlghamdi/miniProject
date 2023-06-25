package com.example.demo.csv;

import java.io.IOException;
import java.util.List;

import com.example.demo.game.Game;
import com.example.demo.game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class CSVService {
    @Autowired
    GameRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Game> games = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll( games );
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
    public List<Game> getGames() {
        return repository.findAll();
    }
}
