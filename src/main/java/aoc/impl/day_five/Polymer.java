package aoc.impl.day_five;

/**
 * Created by Jason MK on 2018-12-08 at 3:02 AM
 */
public class Polymer {

    private final String value;

    public Polymer(String value) {
        this.value = value;
    }

    public String react() {
        String value = this.value;

        while (true) {
            String result = react(value);

            if (result.equals(value)) {
                break;
            }
            value = result;
        }
        return value;
    }

    public String react(char ommit) {
        Polymer polymer = new Polymer(value.replaceAll(String.format("[%s%s]",
                Character.toLowerCase(ommit), Character.toUpperCase(ommit)), ""));

        return polymer.react();
    }

    public int shortest() {
        int shortest = Integer.MAX_VALUE;

        for (char character = 'A'; character < 'Z'; character++) {
            String result = react(character);

            if (result.length() < shortest) {
                shortest = result.length();
            }
        }
        return shortest;
    }

    private String react(String value) {
        for (int index = 0; index < value.length() - 1; index++) {
            if (index + 1 >= value.length()) {
                break;
            }
            char charAt = value.charAt(index);

            char charCompare = value.charAt(index + 1);

            if (charAt == charCompare) {
                continue;
            }
            if (Character.toLowerCase(charAt) == charCompare || Character.toLowerCase(charCompare) == charAt) {
                value = value.substring(0, index).concat(value.substring(index + 2));
                break;
            }
        }
        return value;
    }
}
