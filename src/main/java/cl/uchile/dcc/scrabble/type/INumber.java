package cl.uchile.dcc.scrabble.type;

/**
 * Implementation of an interface for a Scrabble numeral type
 * @author Victor Vidal Paz
 */
public interface INumber {

    /**
     * toScrabbleFloat: Method for transforming a Scrabble numeral type to a Scrabble Float
     * @return ScrabbleFloat being the result of the transformation.
     */
    ScrabbleFloat toScrabbleFloat();

    /**
     * add: Method for adding two Scrabble numerals.
     * @param sNumber ScrabbleNumber added to the right.
     * @return INumber being the result of the addition.
     */
    INumber add(INumber sNumber);

    /**
     * subtract: Method for subtracting two Scrabble numerals.
     * @param sNumber ScrabbleNumber subtracted to the right.
     * @return INumber being the result of the subtraction.
     */
    INumber subtract(INumber sNumber);

    /**
     * multiply: Method for multiplying two Scrabble numerals.
     * @param sNumber ScrabbleNumber multiplied to the right.
     * @return INumber being the result of the multiplication.
     */
    INumber multiply(INumber sNumber);

    /**
     * divide: Method for dividing two Scrabble Numerals.
     * @param sNumber ScrabbleNumber divided to the right. Its value mustn't be zero.
     * @return INumber being the result of the division.
     */
    INumber divide(INumber sNumber);

    /**
     * intPlus: Method that adds a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the addition. Its priority is trying to be a ScrabbleInt.
     */
    INumber intPlus(ScrabbleInt sInt);

    /**
     * intMinus: Method that subtracts a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the subtraction. Its priority is trying to be a ScrabbleInt.
     */
    INumber intMinus(ScrabbleInt sInt);

    /**
     * intTimes: Method that multiplies a Scrabble int with a Scrabble numeral.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the multiplication. Its priority is trying to be a ScrabbleInt.
     */
    INumber intTimes(ScrabbleInt sInt);

    /**
     * intDividedBy: Method that divides a Scrabble int with a Scrabble numeral. The value of the ScrabbleNumber
     * mustn't be zero.
     * @param sInt ScrabbleInt being operated on the left.
     * @return INumber being the result of the division. Its priority is to be a ScrabbleInt.
     */
    INumber intDividedBy(ScrabbleInt sInt);

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
}
