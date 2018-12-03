package aoc.impl.day_three;

import aoc.DayTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Jason MK on 2018-12-03 at 8:53 AM
 */
public class DayThreeTest implements DayTest<DayThree> {

    @Override
    public DayThree day() {
        return new DayThree();
    }

    @Test
    @Override
    public void assertPartOne() {
        Fabric fabric = new Fabric(Arrays.asList(
                Claim.valueOf("#1 @ 1,3: 4x4"),
                Claim.valueOf("#2 @ 3,1: 4x4"),
                Claim.valueOf("#3 @ 5,5: 2x2")), 10, 10);

        System.out.println("Overlapping: " + fabric.getIntersects());

        System.out.println("Map:");
        System.out.println(fabric.toString().replaceAll("null", "-"));
    }

    @Test
    @Override
    public void assertPartTwo() {
        Fabric fabric = new Fabric(Arrays.asList(
                Claim.valueOf("#1 @ 1,3: 4x4"),
                Claim.valueOf("#2 @ 3,1: 4x4"),
                Claim.valueOf("#3 @ 5,5: 2x2")), 10, 10);

        Claim nonIntersected = fabric.findNonIntersected();

        System.out.println("non intersected: " + nonIntersected);

        assert nonIntersected != null;
    }

    @Test
    @Override
    public void outputPartOne() {
        System.out.println("Answer for part 1: " + day().firstAnswer());
    }

    @Test
    @Override
    public void outputPartTwo() {
        System.out.println("Answer for part 2: " + day().secondAnswer());
    }
}
