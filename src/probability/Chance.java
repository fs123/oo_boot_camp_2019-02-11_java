/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

package probability;

// Understands the likelihood of something occurring
public class Chance {
    private static final double CERTAIN_FRACTION = 1.0;
    private static final double DELTA = 0.000000001;
    private final double fraction;

    public Chance(double likelihoodAsFraction) {
        fraction = likelihoodAsFraction;
    }

    @Override
    public boolean equals(Object other) {
        return this == other ||
                other != null && other.getClass() == Chance.class && this.equals((Chance) other);
    }

    private boolean equals(Chance other) {
        return Math.abs(this.fraction - other.fraction) < DELTA;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(fraction);
    }

    public Chance not() {
        return new Chance(CERTAIN_FRACTION - fraction);
    }

    public Chance and(Chance other) {
        return new Chance(this.fraction * other.fraction);
    }
}
