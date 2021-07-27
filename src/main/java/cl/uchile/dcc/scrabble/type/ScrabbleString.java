package cl.uchile.dcc.scrabble.type;

import java.util.Objects;

/**
 * Implementation of a Scrabble string as a class.
 * @author Victor Vidal Paz
 */
public class ScrabbleString extends AbstractType {

    private final String value;

    /**
     * Constructor of ScrabbleString.
     * @param string Java String.
     */
    public ScrabbleString(String string) {
        this.value = string;
    }

    /**
     * getValue: Getter of this class's value.
     * @return Java String being the value of this instance.
     */
    public String getValue() {
        return value;
    }

    /**
     * toString: Method for transforming a Scrabble type to a Java String.
     * @return String representing the value of the Scrabble string.
     */
    @Override
    public String toString() { return this.getValue(); }

    /**
     * toScrabbleInt: Method for transforming a Scrabble number to ScrabbleInt.
     * @return ScrabbleInt being the result of the operation.
     */
    @Override
    public ScrabbleInt toScrabbleInt() {
        return null;
    }

    /**
     * hashCode: Override from Object, used for proper hashing of the types using its value.
     * @return int being the hash code of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleString.class, value);
    }

    /**
     * equals: Override from Object, used for comparing two different objects.
     * @param obj Object to compare.
     * @return boolean that determines if two objects have the exact same values and share the same instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleString) {
            var o = (ScrabbleString) obj;
            return this.getValue().equals(o.getValue());
        }
        return false;
    }

    /**
     * addToString: Operation that adds a Scrabble string with a Scrabble type. By default this sum is done by transforming
     * the type to string and then concatenating it's values.
     * @param sType ScrabbleType concatenated to the right.
     * @return ScrabbleString containing the concatenation as its value.
     */
    public ScrabbleString addToString(IType sType) {
        return new ScrabbleString(this.getValue() + sType.toString());
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
     *
     * @return IType with the negated value.
     */
    @Override
    public IType negate() {
        return null;
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
     * pseudoCodeString: Method for printing pseudo-code for a tree.
     */
    @Override
    public String pseudoCodeString() {
        return "new String(" + value + ")";
    }
}
