package aoc.impl.day_four;

import aoc.DayTest;
import aoc.DayUtils;
import javafx.util.Pair;
import org.junit.Test;

import java.util.List;

/**
 * Created by Jason MK on 2018-12-04 at 12:40 AM
 */
public class DayFourTest implements DayTest<DayFour> {

    @Override
    public DayFour day() {
        return new DayFour(DayUtils.findInput(4));
    }

    @Test
    @Override
    public void assertPartOne() {
        DayFour dayFour = new DayFour(DayUtils.findInput("day_4_test.txt"));

        List<Record> records = dayFour.decode();

        String max = dayFour.maxMinutes(records).getKey();

        assert dayFour.minuteMostAsleep(records, max) == 24;
    }

    @Test
    @Override
    public void assertPartTwo() {
        DayFour dayFour = new DayFour(DayUtils.findInput("day_4_test.txt"));

        Pair<String, Integer> result = dayFour.minuteMostAsleepPartTwo();

        assert Integer.parseInt(result.getKey().replaceAll("#", "")) * result.getValue() == 4455;
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
