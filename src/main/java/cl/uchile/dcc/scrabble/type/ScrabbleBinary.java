package cl.uchile.dcc.scrabble.type;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Implementation of a Scrabble binary as a class. A binary is a number type and a logical type since it can operate
 * as a number and a boolean.
 *
 * <p>There are two types of binaries:</p>
 * <ul>
 *     <li>An "int" binary, whose value is a string of ones and zeros following the two's components standard.</li>
 *     <li>A "double" binary, whose value is also a string of ones and zeros following the Double (IEEE754
 *     Double precision 64-bit) standard.</li>
 * </ul>
 *
 * @author Victor Vidal Paz
 */
public class ScrabbleBinary extends AbstractType implements INumber, ILogical {

    private final String value;

    /**
     * Constructor for a ScrabbleBinary.
     * @param binary String of ones and zeros, where it can be an "int" representation or a "double" representation.
     */
    public ScrabbleBinary(String binary) {
        this.value = binary;
    }

    /**
     * getValue: getter of this class's value. Since is a string, this method is equivalent to "toString" method,
     * but is implemented for design reasons.
     * @return Java String being the value of this instance.
     */
    public String getValue() { return value; }

    /**
     * toString: Method for transforming a Scrabble type to a Java String.
     * @return String representing the value of the Scrabble binary.
     */
    @Override
    public String toString() {
        return this.getValue();
    }

    /**
     * negate: Method for negating the value of a Scrabble type.
     * @return IType with the negated value. In this case the inversion is applied using the two's components inverse
     * value assuming an "int" binary.
     */
    @Override
    public IType negate() {
        String ans = value.replaceAll("0","x");
        ans = ans.replaceAll("1","0");
        ans = ans.replaceAll("x","1");
        return new ScrabbleBinary(ans);
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
        if (obj instanceof ScrabbleBinary) {
            var o = (ScrabbleBinary) obj;
            return this.getValue().equals(o.getValue());
        }
        return false;
    }

    /**
     * toScrabbleFloat: Method for transforming a Scrabble numeral type to a Scrabble Float
     * @return ScrabbleFloat being the result of the transformation.
     */
    @Override
    public ScrabbleFloat toScrabbleFloat() {
        // Double (IEEE754 Double precision 64-bit) format used for transformations between binary and float.
        double toDouble = Double.longBitsToDouble(new BigInteger(this.getValue(), 2).longValue());
        return new ScrabbleFloat(toDouble);
    }

    /**
     * toScrabbleInt: Method for transforming a Scrabble binary to a Scrabble int. The binary value must be expressed
     * in two's components notation.
     * @return ScrabbleInt being the result of the transformation.
     */
    public ScrabbleInt toScrabbleInt() {
        if (bitToInt(this.getValue().charAt(0)) == 0) {
            return new ScrabbleInt(positiveBinaryToInt(this.getValue()));
        } else {
            return new ScrabbleInt(negativeBinaryToInt(this.getValue()));
        }
    }

    /**
     * bitToInt: Auxiliary method that transforms a bit represented as a char to int.
     * @param charAt bit to transform.
     * @return Java int representing a bit. It's 0 if charAt is '0'. If not, then '1'.
     */
    private int bitToInt(char charAt) {
        return charAt == '0' ? 0 : 1;
    }

    /**
     * negativeBinaryToInt: Auxiliary method that transforms a negative binary (using two`s component) to int.
     * @param value String containing the binary number.
     * @return Java int being the result of the transformation.
     */
    private int negativeBinaryToInt(String value) {
        value = inverseTwosComponent(value);
        return -positiveBinaryToInt(value);
    }

    /**
     * positiveBinaryToInt: Auxiliary method that transforms a positive binary to int.
     * @param value String containing the binary number.
     * @return Java int being the result of the transformation.
     */
    private int positiveBinaryToInt(String value) {
        return Integer.parseInt(value, 2);
    }

    /**
     * inverseTwosComponent: Algorithm to invert a negative binary to it's positive value.
     * <p>Algorithm:</p>
     * <ol>
     *     <li>Subtract a bit to the binary number</li>
     *     <li>Shift the '1' bits to '0' and vice versa</li>
     * </ol>
     * @param binary String containing the binary number.
     * @return String being the result of the algorithm.
     */
    protected String inverseTwosComponent(String binary) {
        int i = 63;   // 64 bits
        while (binary.charAt(i) == '0') { i--; }
        String ans = binary.substring(0, i) + '0';
        ans = ans + "1".repeat(63-i);
        ans = ans.replaceAll("0", "x");
        ans = ans.replaceAll("1", "0");
        ans = ans.replaceAll("x", "1");
        return ans;
    }

    /**
     * toScrabbleBinary: Method that transforms a ScrabbleBinary to ScrabbleBinary. Useful to share copies of the
     * object.
     * @return ScrabbleBinary being a clone of this object.
     */
    public ScrabbleBinary toScrabbleBinary() {
        return new ScrabbleBinary(this.getValue());
    }

    /**
     * and: Logical conjunction operator between two Scrabble logical types.
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return ILogical being the result of the conjunction. In this case is always a ScrabbleBinary.
     */
    @Override
    public ILogical and(ILogical sLogical) {
        String left = this.toString(), right = sLogical.toString();
        if (right.length() == 1) {
            if (right.equals("1")) {
                return new ScrabbleBinary(left);
            } else {
                return new ScrabbleBinary("0".repeat(64));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0 ; i < 64; i++) {
            if (left.charAt(i) == '0' || right.charAt(i) == '0') {
                ans.append("0");
            } else {
                ans.append("1");
            }
        }
        return new ScrabbleBinary(ans.toString());
    }

    /**
     * or: Logical disjunction operator between two Scrabble logical types.
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return ILogical being the result of the disjunction.
     */
    @Override
    public ILogical or(ILogical sLogical) {
        String left = this.toString(), right = sLogical.toString();
        if (right.length() == 1) {
            if (right.equals("1")) {
                return new ScrabbleBinary("1".repeat(64));
            } else {
                return new ScrabbleBinary(left);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0 ; i < 64; i++) {
            if (left.charAt(i) == '1' || right.charAt(i) == '1') {
                ans.append("1");
            } else {
                ans.append("0");
            }
        }
        return new ScrabbleBinary(ans.toString());
    }

    /**
     * add: Method for adding two Scrabble numerals.
     * @param sNumber ScrabbleNumber added to the right.
     * @return INumber being the result of the addition. In this case is always a ScrabbleBinary.
     */
    @Override
    public INumber add(INumber sNumber) {
        return sNumber.binaryPlus(this);
    }

    /**
     * subtract: Method for subtracting two Scrabble numerals.
     * @param sNumber ScrabbleNumber subtracted to the right.
     * @return INumber being the result of the subtraction. In this case is always a ScrabbleBinary.
     */
    @Override
    public INumber subtract(INumber sNumber) {
        return sNumber.binaryMinus(this);
    }

    /**
     * multiply: Method for multiplying two Scrabble numerals.
     * @param sNumber ScrabbleNumber multiplied to the right.
     * @return INumber being the result of the multiplication. In this case is always a ScrabbleBinary.
     */
    @Override
    public INumber multiply(INumber sNumber) {
        return sNumber.binaryTimes(this);
    }

    /**
     * divide: Method for dividing two Scrabble Numerals.
     * @param sNumber ScrabbleNumber divided to the right. Its value mustn't be zero.
     * @return INumber being the result of the division. In this case is always a ScrabbleBinary.
     */
    @Override
    public INumber divide(INumber sNumber) {
        return sNumber.binaryDividedBy(this);
    }

    /**
     * intPlus: Method that adds a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the addition. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public INumber intPlus(ScrabbleInt sInt) {
        int num = binaryToInt(this);
        int ans = sInt.getValue() + num;
        return new ScrabbleInt(ans);
    }

    /**
     * intMinus: Method that subtracts a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the subtraction. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public INumber intMinus(ScrabbleInt sInt) {
        int num = binaryToInt(this);
        int ans = sInt.getValue() - num;
        return new ScrabbleInt(ans);
    }

    /**
     * intTimes: Method that multiplies a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the multiplication. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public INumber intTimes(ScrabbleInt sInt) {
        int num = binaryToInt(this);
        int ans = sInt.getValue() * num;
        return new ScrabbleInt(ans);
    }

    /**
     * intDividedBy: Method that divides a Scrabble int with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the division. Its priority is to be a ScrabbleInt.
     */
    @Override
    public INumber intDividedBy(ScrabbleInt sInt) {
        if (!this.getValue().equals("0".repeat(64))) {
            int num = binaryToInt(this);
            int ans = sInt.getValue() / num;
            return new ScrabbleInt(ans);
        }
        return null;    // Can't divide by zero.
    }

    /**
     * floatPlus: Method that adds a Scrabble float with a Scrabble numeral.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the addition.
     */
    @Override
    public ScrabbleFloat floatPlus(ScrabbleFloat sFloat) {
        ScrabbleFloat right = this.toScrabbleFloat();
        return new ScrabbleFloat(sFloat.getValue() + right.getValue());
    }

    /**
     * floatMinus: Method that subtracts a Scrabble float with a Scrabble numeral.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the subtraction.
     */
    @Override
    public ScrabbleFloat floatMinus(ScrabbleFloat sFloat) {
        ScrabbleFloat right = this.toScrabbleFloat();
        return new ScrabbleFloat(sFloat.getValue() - right.getValue());
    }

    /**
     * floatTimes: Method that multiplies a Scrabble float with a Scrabble numeral.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the multiplication.
     */
    @Override
    public ScrabbleFloat floatTimes(ScrabbleFloat sFloat) {
        ScrabbleFloat right = this.toScrabbleFloat();
        return new ScrabbleFloat(sFloat.getValue() * right.getValue());
    }

    /**
     * floatDividedBy: Method that divides a Scrabble float with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the multiplication.
     */
    @Override
    public ScrabbleFloat floatDividedBy(ScrabbleFloat sFloat) {
        if (!this.getValue().equals("0".repeat(64))) {
            ScrabbleFloat right = this.toScrabbleFloat();
            return new ScrabbleFloat(sFloat.getValue() / right.getValue());
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
        int numLeft = binaryToInt(sBinary);
        int numRight = binaryToInt(this);
        int ans = numLeft + numRight;
        String binaryAns = Integer.toBinaryString(Math.abs(ans));
        binaryAns = "0".repeat(64 - binaryAns.length()) + binaryAns;
        binaryAns = ans >= 0 ? binaryAns : sBinary.inverseTwosComponent(binaryAns);
        return new ScrabbleBinary(binaryAns);
    }

    /**
     * binaryMinus: Method that subtracts a Scrabble binary with a Scrabble numeral.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the subtraction.
     */
    @Override
    public ScrabbleBinary binaryMinus(ScrabbleBinary sBinary) {
        int numLeft = binaryToInt(sBinary);
        int numRight = binaryToInt(this);
        int ans = numLeft - numRight;
        String binaryAns = Integer.toBinaryString(Math.abs(ans));
        binaryAns = "0".repeat(64 - binaryAns.length()) + binaryAns;
        binaryAns = ans >= 0 ? binaryAns : sBinary.inverseTwosComponent(binaryAns);
        return new ScrabbleBinary(binaryAns);
    }

    /**
     * binaryTimes: Method that multiplies a Scrabble binary with a Scrabble numeral.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the multiplication.
     */
    @Override
    public ScrabbleBinary binaryTimes(ScrabbleBinary sBinary) {
        int numLeft = binaryToInt(sBinary);
        int numRight = binaryToInt(this);
        int ans = numLeft * numRight;
        String binaryAns = Integer.toBinaryString(Math.abs(ans));
        binaryAns = "0".repeat(64 - binaryAns.length()) + binaryAns;
        binaryAns = ans >= 0 ? binaryAns : sBinary.inverseTwosComponent(binaryAns);
        return new ScrabbleBinary(binaryAns);
    }

    /**
     * binaryDividedBy: Method that divides a Scrabble binary with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the division.
     */
    @Override
    public ScrabbleBinary binaryDividedBy(ScrabbleBinary sBinary) {
        if (!this.getValue().equals("0".repeat(64))) {
            int numLeft = binaryToInt(sBinary);
            int numRight = binaryToInt(this);
            int ans = numLeft / numRight;
            String binaryAns = Integer.toBinaryString(Math.abs(ans));
            binaryAns = "0".repeat(64 - binaryAns.length()) + binaryAns;
            binaryAns = ans >= 0 ? binaryAns : sBinary.inverseTwosComponent(binaryAns);
            return new ScrabbleBinary(binaryAns);
        }
        return null;    // Can't divide by zero.
    }
}
