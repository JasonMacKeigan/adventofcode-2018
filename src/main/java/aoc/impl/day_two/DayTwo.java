package aoc.impl.day_two;

import aoc.Day;
import aoc.DayUtils;

/**
 * Created by Jason MK on 2018-12-02 at 9:12 AM
 */
public class DayTwo implements Day<Integer, String> {

    private final BoxList boxList = BoxList.fromFile(DayUtils.findInput(this), 2, 3);

    @Override
    public int day() {
        return 2;
    }

    @Override
    public Integer firstAnswer() {
        return boxList.getChecksum();
    }

    @Override
    public String secondAnswer() {
        return boxList.difference();
    }

}
