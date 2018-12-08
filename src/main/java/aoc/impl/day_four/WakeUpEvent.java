package aoc.impl.day_four;

import java.time.LocalDateTime;

public class WakeUpEvent extends Event {

    public WakeUpEvent(LocalDateTime date) {
        super(date, EventType.WAKES_UP);
    }
}