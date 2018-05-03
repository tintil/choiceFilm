package com.diplom.ogromazina.choicefilm.data.utils;

/**
 * Created by OGromazina on 4/22/2018.
 */

public enum Constants {
    indifference(-1),
    dominance(1),
    dominated(0),
    nocomparable(2);

    private final int index;

    Constants(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }

}
