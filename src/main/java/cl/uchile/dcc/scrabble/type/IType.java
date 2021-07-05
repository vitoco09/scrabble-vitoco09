package cl.uchile.dcc.scrabble.type;

import cl.uchile.dcc.scrabble.operationTree.Component;

/**
 * Implementation of an interface for a Scrabble type.
 * @author Victor Vidal Paz
 */
public interface IType extends Component {

    /**
     * toString: Method for transforming a Scrabble type to a Java String.
     * @return String representing the value of a type.
     */
    String toString();


    /**
     * toScrabbleInt: Method for transforming a Scrabble number to ScrabbleInt.
     * @return ScrabbleInt being the result of the operation.
     */
    ScrabbleInt toScrabbleInt();

    /**
     * toScrabbleString(): Method for transforming a Scrabble type to a Scrabble String.
     * @return ScrabbleString representing the type.
     */
    ScrabbleString toScrabbleString();

    /**
     * addToString: Method for concatenating a Scrabble Type to a Scrabble String.
     * @param sType Scrabble number being added.
     * @return ScrabbleString being the result of the concatenation.
     */
    ScrabbleString addToString(IType sType);

    /**
     * toScrabbleFloat: Method for transforming a Scrabble numeral type to a ScrabbleFloat
     * @return ScrabbleFloat being the result of the transformation.
     */
    ScrabbleFloat toScrabbleFloat();

    /**
     * toScrabbleBool: Method for transforming a Scrabble boolean type to a ScrabbleBool
     * @return ScrabbleBool being the result of the transformation.
     */
    ScrabbleBool toScrabbleBool();

    /**
     * toScrabbleBinary: Method for transforming a Scrabble numeral type to a ScrabbleBinary
     * @return ScrabbleBinary being the result of the transformation.
     */
    ScrabbleBinary toScrabbleBinary();

    /**
     * add: Method for adding two Scrabble numerals.
     * @param sNumber ScrabbleNumber added to the right.
     * @return IType being the result of the addition.
     */
    IType add(IType sNumber);

    /**
     * subtract: Method for subtracting two Scrabble numerals.
     * @param sNumber ScrabbleNumber subtracted to the right.
     * @return IType being the result of the subtraction.
     */
    IType subtract(IType sNumber);

    /**
     * multiply: Method for multiplying two Scrabble numerals.
     * @param sNumber ScrabbleNumber multiplied to the right.
     * @return IType being the result of the multiplication.
     */
    IType multiply(IType sNumber);

    /**
     * divide: Method for dividing two Scrabble Numerals.
     * @param sNumber ScrabbleNumber divided to the right. Its value mustn't be zero.
     * @return IType being the result of the division.
     */
    IType divide(IType sNumber);

    /**
     * intPlus: Method that adds a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the addition. Its priority is trying to be a ScrabbleInt.
     */
    IType intPlus(ScrabbleInt sInt);

    /**
     * intMinus: Method that subtracts a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the subtraction. Its priority is trying to be a ScrabbleInt.
     */
    IType intMinus(ScrabbleInt sInt);

    /**
     * intTimes: Method that multiplies a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the multiplication. Its priority is trying to be a ScrabbleInt.
     */
    IType intTimes(ScrabbleInt sInt);

    /**
     * intDividedBy: Method that divides a Scrabble int with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     * @param sInt ScrabbleInt being operated on the left.
     * @return IType being the result of the division. Its priority is to be a ScrabbleInt.
     */
    IType intDividedBy(ScrabbleInt sInt);

    /**
     * floatPlus: Method that adds a Scrabble float with a Scrabble numeral.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the addition.
     */
    ScrabbleFloat floatPlus(ScrabbleFloat sFloat);

    /**
     * floatMinus: Method that subtracts a Scrabble float with a Scrabble numeral.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the subtraction.
     */
    ScrabbleFloat floatMinus(ScrabbleFloat sFloat);

    /**
     * floatTimes: Method that multiplies a Scrabble float with a Scrabble numeral.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the multiplication.
     */
    ScrabbleFloat floatTimes(ScrabbleFloat sFloat);

    /**
     * floatDividedBy: Method that divides a Scrabble float with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     * @param sFloat ScrabbleFloat being operated on the left.
     * @return ScrabbleFloat being the result of the multiplication.
     */
    ScrabbleFloat floatDividedBy(ScrabbleFloat sFloat);

    /**
     * binaryPlus: Method that adds a Scrabble binary with a Scrabble numeral.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the addition.
     */
    ScrabbleBinary binaryPlus(ScrabbleBinary sBinary);

    /**
     * binaryMinus: Method that subtracts a Scrabble binary with a Scrabble numeral.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the subtraction.
     */
    ScrabbleBinary binaryMinus(ScrabbleBinary sBinary);

    /**
     * binaryTimes: Method that multiplies a Scrabble binary with a Scrabble numeral.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the multiplication.
     */
    ScrabbleBinary binaryTimes(ScrabbleBinary sBinary);

    /**
     * binaryDividedBy: Method that divides a Scrabble binary with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     * @param sBinary ScrabbleBinary being operated on the left.
     * @return ScrabbleBinary being the result of the division.
     */
    ScrabbleBinary binaryDividedBy(ScrabbleBinary sBinary);

    /**
     * negate: Method for negating the value of a Scrabble type.
     * @return IType with the negated value.
     */
    IType negate();

    /**
     * and: Logical conjunction operator between two Scrabble logical types.
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return IType being the result of the conjunction.
     */
    IType and(IType sLogical);

    /**
     * or: Logical disjunction operator between two Scrabble logical types.
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return IType being the result of the disjunction.
     */
    IType or(IType sLogical);

}
