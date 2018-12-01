package aoc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Jason MK on 2018-12-01 at 3:00 PM
 */
public final class DayUtils {

    private DayUtils() {

    }

    public static List<String> findInput(int day) {
        try {
            return Files.readAllLines(Paths.get(DayUtils.class.getProtectionDomain().getClassLoader().getResource(String.format("day_%s.txt", day)).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new IllegalStateException("Unable to read all lines.", e);
        }
    }

    public static List<String> findInput(Day day) {
        return findInput(day.day());
    }

}
