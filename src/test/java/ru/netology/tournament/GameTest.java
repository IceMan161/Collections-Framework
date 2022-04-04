package ru.netology.tournament;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game = new Game();

    Player first = new Player(1, "IceMan", 7);
    Player second = new Player(2, "Nomand", 5);

    @Test
    void registration() {
        game.registration(first);
        game.registration(second);

        Player [] expected = new Player[] {first,second};
        Player [] actual = game.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    void findByName() {
        game.registration(first);
        game.registration(second);

        Player expected = first;
        Player player = game.findByName("IceMan");
        assertEquals(expected, player);
    }

    @Test
    void round() {
    }
}