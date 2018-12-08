package aoc.impl.day_four;

import java.time.LocalDateTime;

public class SignInEvent extends Event {

    private final String id;

    public SignInEvent(String id, LocalDateTime date) {
        super(date, EventType.SIGN_IN);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}