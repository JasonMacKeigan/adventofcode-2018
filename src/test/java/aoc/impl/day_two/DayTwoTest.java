package aoc.impl.day_two;

import aoc.Day;
import aoc.DayUtils;
import aoc.DayTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jason MK on 2018-12-02 at 10:05 AM
 */
public class DayTwoTest implements DayTest {

    @Test
    @Override
    public void assertPartOne() {
        BoxList boxList = new BoxList(Arrays.asList(
                new Box("abcdef"), new Box("bababc"), new Box("abbcde"),
                new Box("abcccd"), new Box("aabcdd"), new Box("abcdee"),
                new Box("ababab")), 2, 3);

        assert  boxList.getChecksum() == 12;
    }

    @Override
    public void assertPartTwo() {

    }


    @Test
    @Override
    public void outputPartOne() {
        BoxList boxList = BoxList.fromFile(DayUtils.findInput(new DayTwo()), 2, 3);

        System.out.println("Checksum: " + boxList.getChecksum());
    }

    @Test
    @Override
    public void outputPartTwo() {
        BoxList boxList = BoxList.fromFile(DayUtils.findInput(new DayTwo()), 2, 3);

        System.out.println("Difference is: " + boxList.difference());
    }
}
