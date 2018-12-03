package aoc.impl.day_three;

import aoc.DayUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Jason MK on 2018-12-03 at 9:03 AM
 */
public class Fabric {

    private final Collection<Claim> claims;

    private final ClaimStack[][] grid;

    private final int intersects;

    public Fabric(Collection<Claim> claims, int width, int height) {
        this.claims = claims;
        this.grid = populate(width, height);
        this.intersects = intersections();
    }

    public Fabric() {
        this(DayUtils.findInput(3).stream().map(Claim::valueOf).collect(Collectors.toList()), 1000, 1000);
    }

    private ClaimStack[][] populate(int width, int height) {
        ClaimStack[][] grid = new ClaimStack[width][height];

        for (Claim claim : claims) {
            for (int x = claim.getPosition().getX(); x < claim.getPosition().getX() + claim.getSize().getWidth(); x++) {
                for (int y = claim.getPosition().getY(); y < claim.getPosition().getY() + claim.getSize().getHeight(); y++) {
                    if (grid[y][x] == null) {
                        grid[y][x] = new ClaimStack();
                    }
                    grid[y][x].add(claim);
                }
            }
        }
        return grid;
    }

    private int intersections() {
        int intersections = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == null) {
                    continue;
                }
                if (grid[x][y].size() > 1) {
                    intersections++;
                }
            }
        }
        return intersections;
    }

    public Claim findNonIntersected() {
        for (Claim claim : claims) {
            boolean intersected = false;

            for (int x = claim.getPosition().getX(); x < claim.getPosition().getX() + claim.getSize().getWidth(); x++) {
                for (int y = claim.getPosition().getY(); y < claim.getPosition().getY() + claim.getSize().getHeight(); y++) {
                    if (grid[y][x] == null) {
                        continue;
                    }
                    if (grid[y][x].size() > 1) {
                        intersected = true;
                    }
                }
            }

            if (!intersected) {
                return claim;
            }
        }
        return null;
    }

    public int getIntersects() {
        return intersects;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(grid).replaceAll("],", "],\n");
    }
}
