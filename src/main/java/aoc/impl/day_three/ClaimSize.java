package aoc.impl.day_three;

/**
 * Created by Jason MK on 2018-12-03 at 9:02 AM
 */
public class ClaimSize {

    private final int width;

    private final int height;

    public ClaimSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static ClaimSize valueOf(String encoded) {
        String[] values = encoded.split("x");

        return new ClaimSize(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "ClaimSize{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
