package aoc.impl.day_four;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class ShiftSleep {

    private final LocalDateTime start;

    private final LocalDateTime end;

    private final Duration duration;

    public ShiftSleep(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
        this.duration = Duration.between(start, end);
    }

    public Duration getDuration() {
        return duration;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}