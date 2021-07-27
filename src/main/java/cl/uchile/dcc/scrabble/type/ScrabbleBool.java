package cl.uchile.dcc.scrabble.type;

import java.util.Objects;

/**
 * Implementation of a Scrabble boolean as a class. It stores a Java boolean value, so there are only two possible
 * Scrabble booleans with different values.
 * @author Victor Vidal Paz
 */
public class ScrabbleBool extends AbstractType {

    private final boolean value;

    /**
     * Constructor of ScrabbleBool.
     * @param bool Java boolean.
     */
    public ScrabbleBool(boolean bool) {
        this.value = bool;
    }

    /**
     * getValue: Getter of this class's value.
     * @return Java boolean being the value of this instance.
     */
    public boolean getValue() { return value; }

    /**
     * toString: Method for transforming a Scrabble type to a Java String.
     * @return String representing the value of the Scrabble boolean. If true, then returns "1". If not, then "0".
     */
    @Override
    public String toString() {
        return value ? "1" : "0";
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

    /**
     * addToString: Method for concatenating a Scrabble Type to a Scrabble String.
     *
     * @param sType Scrabble number being added.
     * @return ScrabbleString being the result of the concatenation.
     */
    @Override
    public ScrabbleString addToString(IType sType) {
        return null;
    }

    /**
     * toScrabbleFloat: Method for transforming a Scrabble numeral type to a Scrabble Float
     *
     * @return ScrabbleFloat being the result of the transformation.
     */
    @Override
    public ScrabbleFloat toScrabbleFloat() {
        return null;
    }

    /**
     * add: Method for adding two Scrabble numerals.
     *
     * @param sNumber ScrabbleNumber added to the right.
     * @return IType being the result of the addition.
     */
    @Override
    public IType add(IType sNumber) {
        return null;
    }

    /**
     * subtract: Method for subtracting two Scrabble numerals.
     *
     * @param sNumber ScrabbleNumber subtracted to the right.
     * @return IType being the result of the subtraction.
     */
    @Override
    public IType subtract(IType sNumber) {
        return null;
    }

    /**
     * multiply: Method for multiplying two Scrabble numerals.
     *
     * @param sNumber ScrabbleNumber multiplied to the right.
     * @return IType being the result of the multiplication.
     */
    @Override
    public IType multiply(IType sNumber) {
        return null;
    }

    /**
     * divide: Method for dividing two Scrabble Numerals.
     *
     * @param sNumber ScrabbleNumber divided to the right. Its value mustn't be zero.
     * @return IType being the result of the division.
     */
    @Override
    public IType divide(IType sNumber) {
        return null;
    }

    /**
     * intPlus: Method that adds a Scrabble int with a Scrabble numeral.
     *
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the addition. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public IType intPlus(ScrabbleInt sInt) {
        return null;
    }

    /**
     * intMinus: Method that subtracts a Scrabble int with a Scrabble numeral.
     *
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the subtraction. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public IType intMinus(ScrabbleInt sInt) {
        return null;
    }

    /**
     * intTimes: Method that multiplies a Scrabble int with a Scrabble numeral.
     *
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the multiplication. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public IType intTimes(ScrabbleInt sInt) {
        return null;
    }

    /**
     * intDividedBy: Method that divides a Scrabble int with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     *
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the division. Its priority is to be a ScrabbleInt.
     */
    @Override
    public IType intDividedBy(ScrabbleInt sInt) {
        return null;
    }

    /**
     * floatPlus: Method that adds a Scrabble float with a Scrabble numeral.
     *
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the addition.
     */
    @Override
    public ScrabbleFloat floatPlus(ScrabbleFloat sFloat) {
        return null;
    }

    /**
     * floatMinus: Method that subtracts a Scrabble float with a Scrabble numeral.
     *
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the subtraction.
     */
    @Override
    public ScrabbleFloat floatMinus(ScrabbleFloat sFloat) {
        return null;
    }

    /**
     * floatTimes: Method that multiplies a Scrabble float with a Scrabble numeral.
     *
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the multiplication.
     */
    @Override
    public ScrabbleFloat floatTimes(ScrabbleFloat sFloat) {
        return null;
    }

    /**
     * floatDividedBy: Method that divides a Scrabble float with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     *
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the multiplication.
     */
    @Override
    public ScrabbleFloat floatDividedBy(ScrabbleFloat sFloat) {
        return null;
    }

    /**
     * binaryPlus: Method that adds a Scrabble binary with a Scrabble numeral.
     *
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the addition.
     */
    @Override
    public ScrabbleBinary binaryPlus(ScrabbleBinary sBinary) {
        return null;
    }

    /**
     * binaryMinus: Method that subtracts a Scrabble binary with a Scrabble numeral.
     *
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the subtraction.
     */
    @Override
    public ScrabbleBinary binaryMinus(ScrabbleBinary sBinary) {
        return null;
    }

    /**
     * binaryTimes: Method that multiplies a Scrabble binary with a Scrabble numeral.
     *
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the multiplication.
     */
    @Override
    public ScrabbleBinary binaryTimes(ScrabbleBinary sBinary) {
        return null;
    }

    /**
     * binaryDividedBy: Method that divides a Scrabble binary with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     *
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the division.
     */
    @Override
    public ScrabbleBinary binaryDividedBy(ScrabbleBinary sBinary) {
        return null;
    }

    /**
     * negate: Method for negating the value of a Scrabble type.
     * @return IType with the negated value. In this case the boolean value is negated.
     */
    @Override
    public ScrabbleBool negate() {
        return new ScrabbleBool(!this.getValue());
    }

    /**
     * hashCode: Override from Object, used for proper hashing of the types using its value.
     * @return int being the hash code of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleBool.class, value);
    }

    /**
     * equals: Override from Object, used for comparing two different objects.
     * @param obj Object to compare.
     * @return boolean that determines if two objects have the exact same values and share the same instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleBool) {
            var o = (ScrabbleBool) obj;
            return this.getValue() == o.getValue();
        }
        return false;
    }

    public ScrabbleBool toScrabbleBool() {
        return new ScrabbleBool(this.getValue());
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
     * and: Logical conjunction operator between two Scrabble logical types.
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return ILogical being the result of the conjunction. It can be a ScrabbleBool or a ScrabbleBinary.
     */
    @Override
    public IType and(IType sLogical) {
        String left = this.toString(), right = sLogical.toString();
        if (right.length() == 1) {
            return new ScrabbleBool(left.equals(right) && left.equals("1"));
        } else {
            if (left.equals("1")) {
                return new ScrabbleBinary(right);
            } else {
                return new ScrabbleBinary("0".repeat(64));
            }
        }
    }

    /**
     * or: Logical disjunction operator between two Scrabble logical types.
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return ILogical being the result of the disjunction. It can be a ScrabbleBool or a ScrabbleBinary.
     */
    @Override
    public IType or(IType sLogical) {
        String left = this.toString(), right = sLogical.toString();
        if (right.length() == 1) {
            if (left.equals("1")) {
                return new ScrabbleBool(true);
            } else {
                return new ScrabbleBool(right.equals("1"));
            }
        } else {
            if (left.equals("1")) {
                return new ScrabbleBinary("1".repeat(64));
            } else {
                return new ScrabbleBinary(right);
            }
        }
    }

    /**
     * pseudoCodeString: Method for printing pseudo-code for a tree.
     */
    @Override
    public String pseudoCodeString() {
        return "new Bool(" + value + ")";
    }

}
