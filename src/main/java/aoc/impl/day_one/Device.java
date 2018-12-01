package aoc.impl.day_one;

import java.util.List;

public class Device {

    private int frequency;

    public void calibrate(int offset) {
        frequency += offset;
    }

    public void calibrate(List<Integer> frequencies) {
        frequency = frequencies.stream().mapToInt(value -> value).sum();
    }

    public int calibrateUntilMatch(List<Integer> records, List<Integer> frequencies) {
        for (int frequency : frequencies) {
            calibrate(frequency);

            if (records.contains(this.frequency)) {
                return this.frequency;
            }
            records.add(this.frequency);
        }
        return calibrateUntilMatch(records, frequencies);
    }

    public int getFrequency() {
        return frequency;
    }
}