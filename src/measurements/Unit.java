package measurements;

public class Unit {


    public static final Unit TEASPOON = new Unit("TEASPOON");
    public static final Unit TABLESPOON = new Unit("TABLESPOON", 3 * TEASPOON.baseMultiplicator);
    public static final Unit OUNCE = new Unit("OUNCE", 2 * TABLESPOON.baseMultiplicator);
    public static final Unit CUP = new Unit("CUP", 8 * OUNCE.baseMultiplicator);
    public static final Unit PINT = new Unit("PINT", 2 * CUP.baseMultiplicator);
    public static final Unit QUART = new Unit("QUART", 2 * PINT.baseMultiplicator);
    public static final Unit GALLON = new Unit("GOLLON", 4 * QUART.baseMultiplicator);

    private String name;
    private final double baseMultiplicator;

    private Unit(String name, double baseMultiplicator) {
        this.name = name;
        this.baseMultiplicator = baseMultiplicator;
    }

    private Unit(String name) {
        this(name, 1);
    }

    public double convertAmount(double otherAmount, Unit otherUnit) {
        return otherAmount * baseMultiplicator / otherUnit.baseMultiplicator;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                '}';
    }
}
//package measurements;
//
//public class Unit {
//
//
//    public static final Unit TEASPOON = new Unit("TEASPOON", 0);
//    public static final Unit TABLESPOON = new Unit("TABLESPOON", 1, 3, TEASPOON);
//    public static final Unit OUNCE = new Unit("OUNCE", 2, 2, TABLESPOON);
//    public static final Unit CUP = new Unit("CUP", 3, 8, OUNCE);
//    public static final Unit PINT = new Unit("PINT", 4, 2, CUP);
//    public static final Unit QUART = new Unit("QUART", 5, 2, PINT);
//    public static final Unit GALLON = new Unit("GOLLON", 6, 4, QUART);
//
//    private String name;
//    private int index;
//    private final double nextUnitMultiplicator;
//    private final Unit nextUnit;
//
//    private Unit(String name, int index, int nextUnitMultiplicator, Unit nextUnit) {
//        this.name = name;
//        this.index = index;
//        this.nextUnitMultiplicator = nextUnitMultiplicator;
//        this.nextUnit = nextUnit;
//    }
//
//    private Unit(String name, int index) {
//        this(name, index, 1, null);
//    }
//
//    public double convertTo(double amount, Unit targetUnit) {
//        if (this.index > targetUnit.index) {
//            return amount * internalMultiplicatorFor(targetUnit, this);
//        } else {
//            return amount / internalMultiplicatorFor(this, targetUnit);
//        }
//    }
//
//    private static double internalMultiplicatorFor(Unit targetUnit, Unit sourceUnit) {
//        if (targetUnit.equals(sourceUnit)) {
//            return 1;
//        }
//        return sourceUnit.nextUnitMultiplicator * internalMultiplicatorFor(targetUnit, sourceUnit.nextUnit);
//    }
//
//    @Override
//    public String toString() {
//        return "Unit{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//}
