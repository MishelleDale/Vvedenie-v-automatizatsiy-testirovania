package org.max.home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
public class MyGameTest {

    private List<Door> doors;

    //тут можно использовать @BeforeAll
    @BeforeEach
    void setUp () {
        doors = new ArrayList<>();
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
    }

    @Test
    void testNoRiskWin () {
        //given
        Player player = new Player("Игрок1", false);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(0);
        //then
        Assertions.assertTrue(door.isPrize());
    }

    @Test
    void testRiskWin () {
        //given
        Player player = new Player("Игрок2", true);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(1);
        //then
        Assertions.assertTrue(door.isPrize());
    }

    @Test
    void testNoRiskLose() {
        //given
        Player player = new Player("Игрок3", false);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(2);
        //then
        Assertions.assertFalse(door.isPrize());
    }

    @Test
    void testRiskLose () {
        //given
        Player player = new Player("Игрок4", true);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(0);
        //then
        Assertions.assertFalse(door.isPrize());
    }
}
