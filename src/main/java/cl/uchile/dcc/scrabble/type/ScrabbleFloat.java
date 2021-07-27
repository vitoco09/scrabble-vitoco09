package cl.uchile.dcc.scrabble.type;

import java.util.Objects;

/**
 * Implementation of a Scrabble float as a class. Despite its name, this type stores a Java double.
 * @author Victor Vidal Paz
 */
public class ScrabbleFloat extends AbstractType {

    private final double value;

    /**
     * Constructor of ScrabbleFloat.
     * @param value double numeral.
     */
    public ScrabbleFloat(double value) {
        this.value = value;
    }

    /**
     * getValue: Getter of this class's value.
     * @return Java double being the value of this instance.
     */
    public double getValue() { return value; }

    /**
     * toString: Method for transforming a Scrabble type to a Java String.
     * @return String representing the value of the Scrabble float.
     */
    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }

    /**
     * toScrabbleInt: Method for transforming a Scrabble number to ScrabbleInt.
     *
     * @return ScrabbleInt being the result of the operation.
     */
    @Override
    public ScrabbleInt toScrabbleInt() {
        return null;
    }

    @Override
    public ScrabbleString addToString(IType sType) {
        return null;
    }

    /**
     * negate: Method for negating the value of a Scrabble type.
     * @return IType with the negated value. In this case the double value is negated.
     */
    @Override
    public IType negate() {
        return new ScrabbleFloat(-this.getValue());
    }

    /**
     * and: Logical conjunction operator between two Scrabble logical types.
     *
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return IType being the result of the conjunction.
     */
    @Override
    public IType and(IType sLogical) {
        return null;
    }

    /**
     * or: Logical disjunction operator between two Scrabble logical types.
     *
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return IType being the result of the disjunction.
     */
    @Override
    public IType or(IType sLogical) {
        return null;
    }

    /**
     * hashCode: Override from Object, used for proper hashing of the types using its value.
     * @return int being the hash code of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleFloat.class, value);
    }

    /**
     * equals: Override from Object, used for comparing two different objects.
     * @param obj Object to compare.
     * @return boolean that determines if two objects have the exact same values and share the same instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleFloat) {
            var o = (ScrabbleFloat) obj;
            return this.getValue() == o.getValue();
        }
        return false;
    }

    /**
     * toScrabbleFloat: Method for transforming a Scrabble numeral type to a Scrabble Float
     * @return ScrabbleFloat being the result of the transformation.
     */
    @Override
    public ScrabbleFloat toScrabbleFloat() {
        return new ScrabbleFloat(this.getValue());
    }

    /**
     * toScrabbleBool: Method for transforming a Scrabble boolean type to a ScrabbleBool
     *
     * @return ScrabbleBool being the result of the transformation.
     */
    @Override
    public ScrabbleBool toScrabbleBool() {
        return null;
    }

    /**
     * toScrabbleBinary: Method for transforming a Scrabble numeral type to a ScrabbleBinary
     *
     * @return ScrabbleBinary being the result of the transformation.
     */
    @Override
    public ScrabbleBinary toScrabbleBinary() {
        return null;
    }

    /**
     * add: Method for adding two Scrabble numerals.
     * @param sNumber ScrabbleNumber added to the right.
     * @return IType being the result of the addition. In this case is always a ScrabbleFloat.
     */
    @Override
    public IType add(IType sNumber) {
        return sNumber.floatPlus(this);
    }

    /**
     * subtract: Method for subtracting two Scrabble numerals.
     * @param sNumber ScrabbleNumber subtracted to the right.
     * @return IType being the result of the subtraction. In this case is always a ScrabbleFloat.
     */
    @Override
    public IType subtract(IType sNumber) {
        return sNumber.floatMinus(this);
    }

    /**
     * multiply: Method for multiplying two Scrabble numerals.
     * @param sNumber ScrabbleNumber multiplied to the right.
     * @return IType being the result of the multiplication. In this case is always a ScrabbleFloat.
     */
    @Override
    public IType multiply(IType sNumber) {
        return sNumber.floatTimes(this);
    }

    /**
     * divide: Method for dividing two Scrabble Numerals.
     * @param sNumber ScrabbleNumber divided to the right. Its value mustn't be zero.
     * @return IType being the result of the division. In this case is always a ScrabbleFloat.
     */
    @Override
    public IType divide(IType sNumber) {
        return sNumber.floatDividedBy(this);
    }

    /**
     * intPlus: Method that adds a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the addition. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public IType intPlus(ScrabbleInt sInt) {
        return new ScrabbleFloat(sInt.getValue() + this.getValue());
    }

    /**
     * intMinus: Method that subtracts a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the subtraction. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public IType intMinus(ScrabbleInt sInt) {
        return new ScrabbleFloat(sInt.getValue() - this.getValue());
    }

    /**
     * intTimes: Method that multiplies a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the multiplication. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public IType intTimes(ScrabbleInt sInt) {
        return new ScrabbleFloat(sInt.getValue() * this.getValue());
    }

    /**
     * intDividedBy: Method that divides a Scrabble int with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the division. Its priority is to be a ScrabbleInt.
     */
    @Override
    public IType intDividedBy(ScrabbleInt sInt) {
        if (this.getValue() != 0) {
            return new ScrabbleFloat(sInt.getValue() / this.getValue());
        }
        return null;    // Can't divide by zero
    }

    /**
     * floatPlus: Method that adds a Scrabble float with a Scrabble numeral.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the addition.
     */
    @Override
    public ScrabbleFloat floatPlus(ScrabbleFloat sFloat) {
        return new ScrabbleFloat(sFloat.getValue() + this.getValue());
    }

    /**
     * floatMinus: Method that subtracts a Scrabble float with a Scrabble numeral.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the subtraction.
     */
    @Override
    public ScrabbleFloat floatMinus(ScrabbleFloat sFloat) {
        return new ScrabbleFloat(sFloat.getValue() - this.getValue());
    }

    /**
     * floatTimes: Method that multiplies a Scrabble float with a Scrabble numeral.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the multiplication.
     */
    @Override
    public ScrabbleFloat floatTimes(ScrabbleFloat sFloat) {
        return new ScrabbleFloat(sFloat.getValue() * this.getValue());
    }

    /**
     * floatDividedBy: Method that divides a Scrabble float with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the multiplication.
     */
    @Override
    public ScrabbleFloat floatDividedBy(ScrabbleFloat sFloat) {
        if (this.getValue() != 0.0d) {
            return new ScrabbleFloat(sFloat.getValue() / this.getValue());
        }
        return null;    // Can't divide by zero.
    }

    /**
     * binaryPlus: Method that adds a Scrabble binary with a Scrabble numeral.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the addition.
     */
    @Override
    public ScrabbleBinary binaryPlus(ScrabbleBinary sBinary) {
        double left = sBinary.toScrabbleFloat().getValue();
        double result = left + this.getValue();
        String binary = Long.toBinaryString(Double.doubleToRawLongBits(Math.abs(result)));
        return new ScrabbleBinary((result >= 0 ? "0" : "1") + binary);
    }

    /**
     * binaryMinus: Method that subtracts a Scrabble binary with a Scrabble numeral.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the subtraction.
     */
    @Override
    public ScrabbleBinary binaryMinus(ScrabbleBinary sBinary) {
        double left = sBinary.toScrabbleFloat().getValue();
        double result = left - this.getValue();
        String binary = Long.toBinaryString(Double.doubleToRawLongBits(Math.abs(result)));
        return new ScrabbleBinary((result >= 0 ? "0" : "1") + binary);
    }

    /**
     * binaryTimes: Method that multiplies a Scrabble binary with a Scrabble numeral.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the multiplication.
     */
    @Override
    public ScrabbleBinary binaryTimes(ScrabbleBinary sBinary) {
        double left = sBinary.toScrabbleFloat().getValue();
        double result = left * this.getValue();
        String binary = Long.toBinaryString(Double.doubleToRawLongBits(Math.abs(result)));
        return new ScrabbleBinary((result >= 0 ? "0" : "1") + binary);
    }

    /**
     * binaryDividedBy: Method that divides a Scrabble binary with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the division.
     */
    @Override
    public ScrabbleBinary binaryDividedBy(ScrabbleBinary sBinary) {
        if (this.getValue() != 0.0d) {
            double left = sBinary.toScrabbleFloat().getValue();
            double result = left / this.getValue();
            String binary = Long.toBinaryString(Double.doubleToRawLongBits(Math.abs(result)));
            binary = binary.length() < 63 ? "0".repeat(63 - binary.length()) + binary : binary;
            return new ScrabbleBinary((result >= 0 ? "0" : "1") + binary);
        }
        return null;    // Can't divide by zero.
    }

    /**
     * pseudoCodeString: Method for printing pseudo-code for a tree.
     */
    @Override
    public String pseudoCodeString() {
        return "new Float(" + value + ")";
    }
}
