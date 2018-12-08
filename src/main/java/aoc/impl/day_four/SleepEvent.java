package aoc.impl.day_four;

import java.time.LocalDateTime;

public class SleepEvent extends Event {

    public SleepEvent(LocalDateTime date) {
        super(date, EventType.FALLS_ASLEEP);
    }
}