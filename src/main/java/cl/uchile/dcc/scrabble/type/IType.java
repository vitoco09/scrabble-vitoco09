package cl.uchile.dcc.scrabble.type;

/**
 * Implementation of an interface for a Scrabble type.
 * @author Victor Vidal Paz
 */
public interface IType {

    /**
     * toString: Method for transforming a Scrabble type to a Java String.
     * @return String representing the value of a type.
     */
    String toString();

    /**
     * toScrabbleString(): Method for transforming a Scrabble type to a Scrabble String.
     * @return ScrabbleString representing the type.
     */
    ScrabbleString toScrabbleString();

    /**
     * negate: Method for negating the value of a Scrabble type.
     * @return IType with the negated value.
     */
    IType negate();

}
