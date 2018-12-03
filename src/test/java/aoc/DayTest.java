package aoc;

import aoc.Day;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Jason MK on 2018-12-02 at 12:41 PM
 */
public interface DayTest<D extends Day> {

    D day();
    
    void assertPartOne();

    void assertPartTwo();

    void outputPartOne();

    void outputPartTwo();
}
