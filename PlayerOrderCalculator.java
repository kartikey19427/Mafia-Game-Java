package com.company;

import java.util.Comparator;

public class PlayerOrderCalculator implements Comparator<Player> {

    @Override
    public int compare(Player t1, Player t2) {

        return t1.getId()-t2.getId();
    }
}
