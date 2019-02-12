package measurements;

import java.util.Objects;


public class Quantity {
    private final double amount;
    private final Unit unit;

    public Quantity(double amount, Unit unit) {
        this.unit = unit;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Quantity that = (Quantity) other;
        return this.asTeaspoonAmount() == that.asTeaspoonAmount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(asTeaspoonAmount());
    }

    private double asTeaspoonAmount() {
        return unit.convertAmount(amount, Unit.TEASPOON);
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "amount=" + amount +
                ", unit=" + unit +
                ", asTeaspoonAmount=" + asTeaspoonAmount() +
                '}';
    }

    public Quantity add(Quantity other) {
        return new Quantity(this.asTeaspoonAmount() + other.asTeaspoonAmount(), Unit.TEASPOON);
    }

    public Quantity subtract(Quantity other) {
        return add(other.negate());
    }

    public Quantity negate() {
        return new Quantity(-amount, unit);
    }

    public Quantity transformUnit(Unit targetUnit) {
        double targetAmount = unit.convertAmount(amount, targetUnit);
        return new Quantity(targetAmount, targetUnit);
    }
}
