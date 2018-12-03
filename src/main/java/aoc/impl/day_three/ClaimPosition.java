package aoc.impl.day_three;

import java.util.Objects;

/**
 * Created by Jason MK on 2018-12-03 at 8:59 AM
 */
public class ClaimPosition {

    private final int x;

    private final int y;

    private final int hashCode;

    public ClaimPosition(int x, int y) {
        this.x = x;
        this.y = y;
        this.hashCode = Objects.hash(x, y);
    }

    public static ClaimPosition valueOf(String encoded) {
        String[] values = encoded.split(",");

        return new ClaimPosition(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ClaimPosition) {
            ClaimPosition otherClaimPosition = (ClaimPosition) other;

            return otherClaimPosition.x == x && otherClaimPosition.y == y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "ClaimPosition{" +
                "x=" + x +
                ", y=" + y +
                ", hashCode=" + hashCode +
                '}';
    }
}
