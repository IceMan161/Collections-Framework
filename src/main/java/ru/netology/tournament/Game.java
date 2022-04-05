package ru.netology.tournament;

import ru.netology.domain.Player;
import ru.netology.exeptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player[] findAll() {
        return players.toArray(new Player[0]);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {

        if (findByName(playerName1) == null && findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок не зарегистрирован");
        }

        int Player1 = findByName(playerName1).getStrength();
        int Player2 = findByName(playerName2).getStrength();
        int point = 0;

        if (Player1 - Player2 > 0) {
            point = 1;
        }
        if (Player1 == Player2) {
            point = 0;
        }
        if (Player1 - Player2 < 0) {
            point = 2;
        }
        return point;
    }
}


