package aoc.impl.day_one;

import aoc.impl.day_one.DayOne;
import aoc.impl.day_one.Device;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jason MK on 2018-12-01 at 3:53 PM
 */
public class DayOneTest {

    private final DayOne dayOne = new DayOne();

    @Test
    public void assertFrequency() {
        Device device = new Device();

        device.calibrate(Arrays.asList(-1, -2, -3));

        assert device.getFrequency() == -6;
    }

    @Test
    public void assertPartTwo() {
        assert new Device().calibrateUntilMatch(new ArrayList<>(), Arrays.asList(-6, +3, +8, +5, -6)) == 5;
    }

    @Test
    public void partOne() {
        System.out.println("Frequency: " + dayOne.firstAnswer());
    }

    @Test
    public void partTwo() {
        System.out.println("Match: " + dayOne.secondAnswer());
    }
}
