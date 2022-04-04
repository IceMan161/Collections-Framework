package ru.netology.tournament;

import ru.netology.domain.Player;
import ru.netology.exeptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Game {
    private Game game = new Game();

    private Collection<Player> players = new ArrayList<>();

    public void registration(Player player) {
        players.add(player);
    }

    public Player[] findAll() {
        return players.toArray(new Player[0]);
    }

    public Player findByName(String name) {
        for (Player item : players) {
            if (item.getName() == name) {
                return item;
            }
        }
        return null;
    }

    public Collection <Player> round(String playerName1, String playerName2) {

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок не зарегистрирован");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок не зарегистрирован");
        }

        Player[] result = new Player[0]; // тут будем хранить подошедшие запросу продукты
        for (Player player : game.findAll()) {
            if (matches(player, playerName1, playerName2)) {
                int length = result.length + 1;
                Player[] tmp = new Player[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = player;
                result = tmp;
                // "добавляем в конец" массива result продукт product
            }
        }
        Arrays.sort(result);
        return List.of(result);
    }

    public boolean matches(Player player, String playerName1, String playerName2) {
        if (player.getName().equalsIgnoreCase(playerName1))
            return player.getName().equalsIgnoreCase(playerName2);
        return false;
    }
}

