package aoc.impl.day_two;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Jason MK on 2018-12-02 at 9:13 AM
 */
public class Box {

    private final String id;

    public Box(String id) {
        this.id = id;
    }

    public List<Integer> scan(int... counts) {
        return IntStream.of(counts).filter(count -> id.chars().anyMatch(character -> id.chars().
                filter(other -> character == other).count() == count)).boxed().collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Box{" +
                "id='" + id + '\'' +
                '}';
    }
}
