package aoc.impl.day_one;

import aoc.Day;
import aoc.DayUtils;
import aoc.impl.day_one.Device;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jason MK on 2018-12-01 at 2:55 PM
 */
public class DayOne implements Day<Integer, Integer> {

    private final List<Integer> frequencies = DayUtils.findInput(1).stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

    private Device device = new Device();

    @Override
    public int day() {
        return 1;
    }

    @Override
    public Integer firstAnswer() {
        device.calibrate(frequencies);

        return device.getFrequency();
    }

    @Override
    public Integer secondAnswer() {
        return device.calibrateUntilMatch(new ArrayList<>(), frequencies);
    }
}
