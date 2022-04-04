package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Player implements Comparable <Player>{
    private int id;
    private String name;
    private int strength;

    @Override
    public int compareTo(Player other) {
        return this.strength - other.strength;
    }
}

