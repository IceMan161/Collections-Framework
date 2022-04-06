package ru.netology.tournament;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exeptions.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game = new Game();

    Player first = new Player(1, "IceMan", 5);
    Player second = new Player(2, "Nomand", 7);
    Player third = new Player(3,"Toxa",2);

    @Test
    void registration() {

        game.register(first);
        game.register(second);


        Player[] expected = new Player[]{first, second};
        Player[] actual = game.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void findByName() {

        game.register(first);
        game.register(second);

        Player expected = second;
        Player player = game.findByName("Nomand");

        assertEquals(expected, player);

    }

    @Test
    void findByNameNull() {

        game.register(first);
        game.register(second);

        Player expected = null;
        Player player = game.findByName("Toxa");

        assertEquals(expected, player);

    }

    @Test
    void roundVictoryFirst() {

        Player first = new Player(1, "IceMan", 17);
        Player second = new Player(2, "Nomand", 7);

        game.register(first);
        game.register(second);

        int expected = 1;
        int actual = game.round("IceMan", "Nomand");

        assertEquals(expected, actual);

    }

    @Test
    void roundVictorySecond() {

        Player first = new Player(1, "IceMan", 5);
        Player second = new Player(2, "Nomand", 7);

        game.register(first);
        game.register(second);

        int expected = 2;
        int actual = game.round("IceMan", "Nomand");

        assertEquals(expected, actual);

    }

    @Test
    void roundDraw() {

        Player first = new Player(1, "IceMan", 5);
        Player second = new Player(2, "Nomand", 5);

        game.register(first);
        game.register(second);

        int expected = 0;
        int actual = game.round("IceMan", "Nomand");

        assertEquals(expected, actual);

    }

    @Test
    void shouldExeptionSecond() {

        game.register(first);

        assertThrows(NotRegisteredException.class, () -> game.round("IceMan","Toxa"));

    }

    @Test
    void shouldExeptionFirst() {

        game.register(second);

        assertThrows(NotRegisteredException.class, () -> game.round("IceMan","Nomand"));

    }
}