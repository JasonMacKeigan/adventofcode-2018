package aoc.impl.day_four;

import aoc.Day;
import javafx.util.Pair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Jason MK on 2018-12-04 at 12:39 AM
 */
public class DayFour implements Day<Integer, Integer> {

    private final List<String> input;

    public DayFour(List<String> input) {
        this.input = input;
    }

    List<Record> decode() {
        return toRecords(toSortedEvents(input));
    }

    public Pair<String, Long> maxMinutes(List<Record> records) {
        Map<String, Long> minutes = new HashMap<>();

        for (Record record : records) {
            minutes.put(record.getId(), minutes.getOrDefault(record.getId(), 0L) + record.minutesAsleep());
        }
        String recordId = minutes.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).orElse(null).getKey();

        return new Pair<>(recordId, minutes.get(recordId));
    }

    public int minuteMostAsleep(List<Record> records, String id) {
        Map<Integer, Integer> minutes = new HashMap<>();

        Set<Record> searched = new HashSet<>();

        for (Record record : records) {
            if (searched.contains(record)) {
                continue;
            }
            if (!record.getId().equals(id)) {
                continue;
            }
            searched.add(record);

            for (Record otherRecord : records) {
                if (otherRecord == record) {
                    continue;
                }
                if (searched.contains(otherRecord)) {
                    continue;
                }
                if (!otherRecord.getId().equals(id)) {
                    continue;
                }
                searched.add(otherRecord);

                for (ShiftSleep shift : record.getShiftSleep()) {
                    for (ShiftSleep other : otherRecord.getShiftSleep()) {
                        if (shift == other) {
                            continue;
                        }
                        for (int minute = shift.getStart().getMinute(); minute < shift.getEnd().getMinute(); minute++) {
                            for (int otherMinute = other.getStart().getMinute(); otherMinute < other.getEnd().getMinute(); otherMinute++) {
                                if (minute == otherMinute) {
                                    minutes.put(minute, minutes.getOrDefault(minute, 0) + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
        Map.Entry<Integer, Integer> result = minutes.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).orElse(null);

        System.out.println(minutes.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).collect(Collectors.toList()));
        if (result == null) {
            throw new IllegalStateException("Could not find minute with most asleep.");
        }
        return result.getKey();
    }

    public Pair<String, Integer> minuteMostAsleepPartTwo() {
        List<Record> records = decode();

        Map<Integer, Pair<String, Integer>> minutes = new HashMap<>();

        for (int minute = 0; minute < 60; minute++) {
            Map<String, Integer> recordMinutes = new HashMap<>();

            for (Record record : records) {
                for (ShiftSleep shift : record.getShiftSleep()) {
                    for (int otherMinute = shift.getStart().getMinute(); otherMinute < shift.getEnd().getMinute(); otherMinute++) {
                        if (minute == otherMinute) {
                            recordMinutes.put(record.getId(), recordMinutes.getOrDefault(record.getId(), 0) + 1);
                        }
                    }
                }
            }
            Map.Entry<String, Integer> max = recordMinutes.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).orElse(null);

            if (max == null) {
                continue;
            }
            minutes.put(minute, new Pair<>(max.getKey(), max.getValue()));
        }
        return minutes.entrySet().stream().max(Comparator.comparingInt(integerPairEntry ->
                integerPairEntry.getValue().getValue())).map(entry -> new Pair<>(entry.getValue().getKey(), entry.getKey())).orElse(null);
    }

    public List<Record> toRecords(List<Event> events) {
        List<Record> records = new ArrayList<>();

        for (int index = 0; index < events.size(); index++) {
            Event event = events.get(index);

            if (event instanceof SignInEvent) {
                SignInEvent signInEvent = (SignInEvent) event;

                Record record = new Record(signInEvent.getId());

                for (; index < events.size(); index += 2) {
                    if (index + 1 >= events.size()) {
                        break;
                    }
                    Event asleep = events.get(index + 1);

                    Event wakeup = events.get(index + 2);

                    if (asleep.getType() == EventType.SIGN_IN || wakeup.getType() == EventType.SIGN_IN) {
                        break;
                    }
                    if (asleep.getType() != EventType.FALLS_ASLEEP) {
                        throw new IllegalStateException(String.format("Event is not asleep for record %s", record.getId()));
                    }
                    if (wakeup.getType() != EventType.WAKES_UP) {
                        throw new IllegalStateException(String.format("Event is not awake for record %s", record.getId()));
                    }
                    record.addShiftSleep(new ShiftSleep(asleep.getDate(), wakeup.getDate()));
                }
                records.add(record);
            }
        }
        return records;
    }

    private List<Event> toSortedEvents(List<String> lines) {
        return lines.stream().map(line -> {
            String[] dateTime = line.substring(1, line.indexOf("]")).split(" ");

            LocalDateTime localDateTime = LocalDateTime.of(LocalDate.parse(dateTime[0]), LocalTime.parse(dateTime[1]));

            String eventTypeLine = line.substring(line.indexOf("]") + 1).trim().toLowerCase();

            return eventTypeLine.startsWith("guard") ? new SignInEvent(eventTypeLine.split(" ")[1], localDateTime)
                    : eventTypeLine.equals("wakes up") ? new WakeUpEvent(localDateTime) : new SleepEvent(localDateTime);
        }).sorted().collect(Collectors.toList());
    }

    @Override
    public int day() {
        return 4;
    }

    @Override
    public Integer firstAnswer() {
        List<Record> records = decode();

        String id = maxMinutes(records).getKey();

        return minuteMostAsleep(records, id) * Integer.parseInt(id.replaceAll("#", ""));
    }

    @Override
    public Integer secondAnswer() {
        Pair<String, Integer> result = minuteMostAsleepPartTwo();

        return Integer.parseInt(result.getKey().replaceAll("#", "")) * result.getValue();
    }

}
