package cl.uchile.dcc.scrabble.type;

import java.util.Objects;

/**
 * Implementation of a Scrabble int as a class.
 * @author Victor Vidal Paz
 */
public class ScrabbleInt extends AbstractType implements INumber {

    private final int value;

    /**
     * Constructor of ScrabbleInt.
     * @param value Java int.
     */
    public ScrabbleInt(int value) {
        this.value = value;
    }

    /**
     * getValue: Getter of this class's value.
     * @return Java int being the value of this instance.
     */
    public int getValue() { return value; }

    /**
     * toString: Method for transforming a Scrabble type to a Java String.
     * @return String representing the value of the Scrabble int.
     */
    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }

    /**
     * negate: Method for negating the value of a Scrabble type.
     * @return IType with the negated value. In this case the int value is negated.
     */
    @Override
    public IType negate() {
        return new ScrabbleInt(-this.getValue());
    }

    /**
     * hashCode: Override from Object, used for proper hashing of the types using its value.
     * @return int being the hash code of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleInt.class, value);
    }

    /**
     * equals: Override from Object, used for comparing two different objects.
     * @param obj Object to compare.
     * @return boolean that determines if two objects have the exact same values and share the same instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleInt) {
            var o = (ScrabbleInt) obj;
            return this.getValue() == o.getValue();
        }
        return false;
    }

    /**
     * toScrabbleFloat: Method for transforming a Scrabble numeral type to a Scrabble Float
     * @return ScrabbleFloat being the result of the transformation.
     */
    public ScrabbleFloat toScrabbleFloat() {
        return new ScrabbleFloat(Double.parseDouble(this.toString()));
    }

    /**
     * toScrabbleInt: Method for transforming a Scrabble int to a Scrabble int. Useful for making copies.
     * @return ScrabbleInt being the copy of this object.
     */
    public ScrabbleInt toScrabbleInt() {
        return new ScrabbleInt(this.getValue());
    }

    /**
     * toScrabbleBinary: Method for transforming a Scrabble int to a Scrabble binary. For this, the two's component
     * format is used for representing negative int values.
     * @return ScrabbleBinary being the result of the transformation.
     */
    public ScrabbleBinary toScrabbleBinary() {
        int num = Math.abs(this.getValue());
        String binary = positiveIntToBinary(num);
        if (this.getValue() < 0) {
            binary = TwosComplement(binary);
        }
        return new ScrabbleBinary(binary);
    }

    /**
     * TwosComponent: Algorithm to invert a positive binary to it's negative value.
     * <p>Algorithm:</p>
     * <ol>
     *     <li>Shift the '1' bits to '0' and vice versa</li>
     *     <li>Add a bit to the binary number</li>
     * </ol>
     * @param binary String containing the binary number.
     * @return String being the result of the algorithm.
     */
    private String TwosComplement(String binary) {
        binary = binary.replaceAll("0", "x");
        binary = binary.replaceAll("1", "0");
        binary = binary.replaceAll("x", "1");
        int i = 63;   // 64 bits
        while (binary.charAt(i) == '1') { i--; }
        String ans = binary.substring(0, i) + "1";
        if (i == 63) {
            return ans;
        } else {
            return ans + String.format("%0" + (63 - i) + "d", 0);
        }
    }

    /**
     * positiveIntToBinary: Method for transforming a positive int to a two's component binary.
     * @param num int to transform
     * @return String being the binary resulting from this.
     */
    private String positiveIntToBinary(int num) {
        String ans = Integer.toBinaryString(num);
        return String.format("%064d", Integer.parseInt(ans));
    }

    /**
     * add: Method for adding two Scrabble numerals.
     * @param sNumber ScrabbleNumber added to the right.
     * @return INumber being the result of the addition. It can be a ScrabbleInt or a ScrabbleFloat.
     */
    @Override
    public INumber add(INumber sNumber) {
        return sNumber.intPlus(this);
    }

    /**
     * subtract: Method for subtracting two Scrabble numerals.
     * @param sNumber ScrabbleNumber subtracted to the right.
     * @return INumber being the result of the subtraction. It can be a ScrabbleInt or a ScrabbleFloat.
     */
    @Override
    public INumber subtract(INumber sNumber) {
        return sNumber.intMinus(this);
    }

    /**
     * multiply: Method for multiplying two Scrabble numerals.
     * @param sNumber ScrabbleNumber multiplied to the right.
     * @return INumber being the result of the multiplication. It can be a ScrabbleInt or a ScrabbleFloat.
     */
    @Override
    public INumber multiply(INumber sNumber) {
        return sNumber.intTimes(this);
    }

    /**
     * divide: Method for dividing two Scrabble Numerals.
     * @param sNumber ScrabbleNumber divided to the right. Its value mustn't be zero.
     * @return INumber being the result of the division. It can be a ScrabbleInt or a ScrabbleFloat.
     */
    @Override
    public INumber divide(INumber sNumber) {
        return sNumber.intDividedBy(this);
    }

    /**
     * intPlus: Method that adds a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the addition. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public INumber intPlus(ScrabbleInt sInt) {
        return new ScrabbleInt(sInt.getValue() + this.getValue());
    }

    /**
     * intMinus: Method that subtracts a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the subtraction. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public INumber intMinus(ScrabbleInt sInt) {
        return new ScrabbleInt(sInt.getValue() - this.getValue());
    }

    /**
     * intTimes: Method that multiplies a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the multiplication. Its priority is trying to be a ScrabbleInt.
     */
    @Override
    public INumber intTimes(ScrabbleInt sInt) {
        return new ScrabbleInt(sInt.getValue() * this.getValue());
    }

    /**
     * intDividedBy: Method that divides a Scrabble int with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the division. Its priority is to be a ScrabbleInt.
     */
    @Override
    public INumber intDividedBy(ScrabbleInt sInt) {
        if (this.getValue() != 0) {
            return new ScrabbleInt(sInt.getValue() / this.getValue());
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
        if (this.getValue() != 0) {
            return new ScrabbleFloat(sFloat.getValue() / this.getValue());
        }
        return null;
    }

    /**
     * binaryPlus: Method that adds a Scrabble binary with a Scrabble numeral.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the addition.
     */
    @Override
    public ScrabbleBinary binaryPlus(ScrabbleBinary sBinary) {
        int num = binaryToInt(sBinary);
        int ans = num + this.getValue();
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
        int num = binaryToInt(sBinary);
        int ans = num - this.getValue();
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
        int num = binaryToInt(sBinary);
        int ans = num * this.getValue();
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
        if (this.getValue() != 0) {
            int num = this.binaryToInt(sBinary);
            int ans = num / this.getValue();
            String binaryAns = Integer.toBinaryString(Math.abs(ans));
            binaryAns = "0".repeat(64 - binaryAns.length()) + binaryAns;
            binaryAns = ans >= 0 ? binaryAns : sBinary.inverseTwosComponent(binaryAns);
            return new ScrabbleBinary(binaryAns);
        }
        return null;    // Can't divide by zero
    }
}
