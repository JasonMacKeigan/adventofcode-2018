package aoc.impl.day_five;

import aoc.Day;

/**
 * Created by Jason MK on 2018-12-08 at 3:01 AM
 */
public class DayFive implements Day<Integer, Integer> {

    private final Polymer polymer;

    public DayFive(String polymer) {
        this.polymer = new Polymer(polymer);
    }

    @Override
    public int day() {
        return 5;
    }

    @Override
    public Integer firstAnswer() {
        return polymer.react().length();
    }

    @Override
    public Integer secondAnswer() {
        return polymer.shortest();
    }
}
