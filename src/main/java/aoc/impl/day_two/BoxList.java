package aoc.impl.day_two;

import org.apache.commons.io.Charsets;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Jason MK on 2018-12-02 at 9:13 AM
 */
public class BoxList {

    private final List<Box> boxes;

    private final int checksum;

    public BoxList(List<Box> boxes, int... counts) {
        this.boxes = boxes;
        this.checksum = checksum(counts);
    }

    public static BoxList fromFile(List<String> lines, int... counts) {
        return new BoxList(lines.stream().map(Box::new).collect(Collectors.toList()), counts);
    }

    public String difference() {
        Queue<Box> closest = boxes.stream().filter(box -> boxes.stream().filter(other ->
                !other.getId().equals(box.getId())).anyMatch(other -> difference(box, other) == 1))
                .limit(2).collect(Collectors.toCollection(ArrayDeque::new));

        if (closest.size() < 2) {
            throw new IllegalStateException("Could not find two boxes with a minimum difference of 1 character.");
        }

        return differenceAsString(closest.poll(), closest.poll());
    }

    private int difference(Box first, Box second) {
        return IntStream.range(0, first.getId().length()).map(index -> first.getId().charAt(index) != second.getId().charAt(index) ? 1 : 0).sum();
    }

    private String differenceAsString(Box first, Box second) {
        return new String(IntStream.range(0, first.getId().length()).filter(index ->
                second.getId().charAt(index) == first.getId().charAt(index)).map(index -> first.getId().charAt(index)).toArray(), 0, first.getId().length() - 1);
    }

    private int checksum(int... counts) {
        return IntStream.of(counts).map(count -> boxes.stream().mapToInt(box -> box.scan(counts).contains(count) ? 1 : 0)
                .sum()).filter(value -> value > 0).reduce(1, (first, second) -> first * second);
    }

    public int getChecksum() {
        return checksum;
    }
}
