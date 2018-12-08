package aoc.impl.day_four;

import java.time.LocalDateTime;

public class Event implements Comparable<Event> {

    private final LocalDateTime date;

    private final EventType type;

    public Event(LocalDateTime date, EventType type) {
        this.date = date;
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public EventType getType() {
        return type;
    }

    @Override
    public int compareTo(Event o) {
        return date.compareTo(o.date);
    }

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                '}';
    }

}