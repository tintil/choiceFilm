package com.diplom.ogromazina.choicefilm.data.utils;

/**
 * Created by OGromazina on 4/22/2018.
 */

public enum Constants {
    indifference(-1),
    dominance(1),
    dominated(0),
    nocomparable(0.5);

    private final double index;

    Constants(double index) {
        this.index = index;
    }

    public double index() {
        return index;
    }

}
