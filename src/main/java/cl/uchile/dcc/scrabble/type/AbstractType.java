package cl.uchile.dcc.scrabble.type;

/**
 * Implementation of a Scrabble type as an abstract class.
 * @author Victor Vidal Paz
 */
public abstract class AbstractType implements IType {

    /**
     * toString: Method for transforming a Scrabble type to a Java String.
     * @return String representing the value of a type.
     */
    @Override
    public abstract String toString();

    /**
     * toScrabbleString(): Method for transforming a Scrabble type to a Scrabble String.
     * @return ScrabbleString representing the type.
     */
    @Override
    public ScrabbleString toScrabbleString() {
        return new ScrabbleString(this.toString());
    }

    /**
     * negate: Method for negating the value of a Scrabble type.
     * @return IType with the negated value.
     */
    @Override
    public abstract IType negate();

    /**
     * binaryToInt: Auxiliary method for transforming a Scrabble binary to Java int.
     * @param scrabbleBinary ScrabbleBinary to transform. It must be in two's component notation.
     * @return int being the result of the transformation of the "int" binary.
     */
    protected int binaryToInt(ScrabbleBinary scrabbleBinary) {
        String binary = scrabbleBinary.getValue();
        boolean isPositive = binary.charAt(0) == '0';
        binary = isPositive ? binary : scrabbleBinary.inverseTwosComponent(binary);
        int k = 0; while (binary.charAt(k) == '0') { k++; }
        binary = binary.substring(k);
        int num = Integer.parseInt(binary, 2);
        return isPositive ? num : -num;
    }

}
