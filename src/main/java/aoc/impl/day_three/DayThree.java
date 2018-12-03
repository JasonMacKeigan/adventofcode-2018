package aoc.impl.day_three;

import aoc.Day;

/**
 * Created by Jason MK on 2018-12-03 at 8:52 AM
 */
public class DayThree implements Day<Integer, String> {

    @Override
    public int day() {
        return 3;
    }

    @Override
    public Integer firstAnswer() {
        return new Fabric().getIntersects();
    }

    @Override
    public String secondAnswer() {
        Fabric fabric = new Fabric();

        Claim nonIntersected = fabric.findNonIntersected();

        System.out.println("non intersected: " + nonIntersected);

        return new Fabric().findNonIntersected().getId();
    }
}
