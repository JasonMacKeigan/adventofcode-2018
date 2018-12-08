package aoc.impl.day_four;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Record {

    private final String id;

    private final List<ShiftSleep> sleep = new ArrayList<>();

    public Record(String id) {
        this.id = id;
    }

    public List<ShiftSleep> getShiftSleep() {
        return sleep;
    }

    public void addShiftSleep(ShiftSleep shiftSleep) {
        sleep.add(shiftSleep);
    }

    public long minutesAsleep() {
        return sleep.stream().mapToLong(sleep -> TimeUnit.SECONDS.toMinutes(sleep.getDuration().getSeconds())).sum();
    }

    public String getId() {
        return id;
    }
}