package aoc.impl.day_five;

import aoc.DayTest;
import aoc.DayUtils;
import org.junit.Test;

/**
 * Created by Jason MK on 2018-12-08 at 3:21 AM
 */
public class DayFiveTest implements DayTest<DayFive> {

    @Override
    public DayFive day() {
        return new DayFive(DayUtils.findInput(5).stream().findAny().orElse(null));
    }

    @Test
    @Override
    public void assertPartOne() {
        Polymer polymer = new Polymer("dabAcCaCBAcCcaDA");

        assert new Polymer("dabAcCaCBAcCcaDA").react().equals("dabCBAcaDA");
        assert new Polymer("aabAAB").react().equals("aabAAB");
        assert new Polymer("abAB").react().equals("abAB");
        assert new Polymer("abBA").react().isEmpty();
        assert new Polymer("aA").react().isEmpty();
    }

    @Test
    @Override
    public void assertPartTwo() {

    }

    @Test
    @Override
    public void outputPartOne() {
        print();
    }

    @Test
    @Override
    public void outputPartTwo() {
        print();
    }
}
