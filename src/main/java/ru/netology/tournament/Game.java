package ru.netology.tournament;

import ru.netology.domain.Player;
import ru.netology.exeptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

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

    public void round(String playerName1, String playerName2) {

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок не зарегистрирован");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок не зарегистрирован");
        }



    }
}

