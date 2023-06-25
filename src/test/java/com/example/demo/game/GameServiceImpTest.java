package com.example.demo.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GameServiceImpTest {

    @Mock
    private GameRepository repo;
    @InjectMocks
    private GameServiceImp service;
    final Date date = Date.valueOf("2021/10/10");
    private Game newGame = new Game(0L, "newGame", "newDeveloper",
            "newGenre", "newPlatform", "newMetacritic_score",
            date, "10");
    final long gameId = 0;

    @BeforeEach
    void setUp(){
        this.service = new GameServiceImp(repo);
    }

    @Test
    void getGames_Exist() throws Exception {
//        //given
//        given(repo.findAll()).willReturn(List.of(newGame));
//        //when
//        service.addGame(newGame);
//        ArgumentCaptor<Game> gameCaptor = ArgumentCaptor.forClass(Game.class);
//        verify(repo).save(gameCaptor.capture());
//
//        //then
//        List<Game> products = service.getGames();
//        assertThat(products).isEqualTo(List.of(newGame));
    }
    @Test
    void getGames_Exception() {
    }

    @Test
    void getGameById_Exist() {
//        //given
//        Game mockGame = new Game(0L, "mockGame", "mockDeveloper",
//                "mockGenre", "mockPlatform", "mockMetacritic_score",
//                date, "20");
//        given(repo.findById(gameId)).willReturn(Optional.of(mockGame));
//        //when
//        Game game = service.getGameById(gameId);
//        //then
//        assertThat(game).isEqualTo(mockGame);
    }
    @Test
    void etGameById_Exception() {
    }

    @Test
    void addGame_Exist() {
    }
    @Test
    void addGame_Exception() {
    }

    @Test
    void updateGame_Exist() {
    }
    @Test
    void updateGame_Exception() {
    }
}