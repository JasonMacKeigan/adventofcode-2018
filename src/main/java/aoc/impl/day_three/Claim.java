package aoc.impl.day_three;

import java.util.Objects;

/**
 * Created by Jason MK on 2018-12-03 at 8:59 AM
 */
public class Claim {

    private final String id;

    private final ClaimPosition position;

    private final ClaimSize size;

    private final int hashCode;

    public Claim(String id, ClaimPosition position, ClaimSize size) {
        this.id = id;
        this.position = position;
        this.size = size;
        this.hashCode = Objects.hash(id);
    }

    public static Claim valueOf(String encoded) {
        String id = encoded.substring(1, encoded.indexOf("@") - 1);

        String position = encoded.substring(encoded.indexOf("@") + 2, encoded.indexOf(":"));

        String size = encoded.substring(encoded.indexOf(":") + 2);

        return new Claim(id, ClaimPosition.valueOf(position), ClaimSize.valueOf(size));
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof Claim) {
            Claim otherClaim = (Claim) other;

            return otherClaim.id.equals(id);
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public ClaimPosition getPosition() {
        return position;
    }

    public ClaimSize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id='" + id + '\'' +
                ", position=" + position +
                ", size=" + size +
                '}';
    }
}
