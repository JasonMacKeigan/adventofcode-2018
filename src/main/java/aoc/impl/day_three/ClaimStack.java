package aoc.impl.day_three;

import java.util.ArrayList;
import java.util.List;

public class ClaimStack {
        
    private final List<Claim> stack;

    public ClaimStack() {
        this(new ArrayList<>());
    }

    public ClaimStack(List<Claim> stack) {
        this.stack = stack;
    }

    public void add(Claim claim) {
        stack.add(claim);
    }

    public int size() {
        return stack.size();
    }


}