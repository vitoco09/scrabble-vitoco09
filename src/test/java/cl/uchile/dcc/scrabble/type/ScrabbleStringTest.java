package cl.uchile.dcc.scrabble.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Testing for ScrabbleString class.
 * @author Victor Vidal Paz
 */
public class ScrabbleStringTest {

    private ScrabbleString sString1;
    private ScrabbleString sString2;
    private final String VALUE_1 = "Holas";
    private final String VALUE_2 = "Chaos";

    @BeforeEach
    void setUp() {
        sString1 = new ScrabbleString(VALUE_1);
        sString2 = new ScrabbleString(VALUE_2);
    }

    @Test
    void constructorTest() {
        var expectedString = new ScrabbleString(VALUE_1);
        assertEquals(expectedString, sString1, "Constructor error");
        assertEquals(expectedString.hashCode(), sString1.hashCode(), "Constructor Hash error");

        var notExpectedString = new ScrabbleString(VALUE_2);
        assertNotEquals(notExpectedString, sString1, "Constructor error");
        assertNotEquals(notExpectedString.hashCode(), sString1.hashCode(), "Constructor Hash error");
    }

    @Test
    void toScrabbleStringTest() {
        var expectedString = new ScrabbleString(VALUE_1);
        assertEquals(expectedString, sString1, "toScrabbleString error");
        assertEquals(expectedString.hashCode(), sString1.hashCode(), "toScrabbleString Hash error");
    }

    @Test
    void toStringTest() {
        assertEquals(VALUE_1, sString1.toString(), "toString error");
    }

    @Test
    void addTest() {
        var expected1 = new ScrabbleString(VALUE_1 + VALUE_2);
        assertEquals(expected1, sString1.addToString(sString2));
        assertEquals(VALUE_1 + VALUE_2, sString1.addToString(sString2).toString());

        var expected2 = new ScrabbleString(VALUE_1 + "0000000000000000000000000000011000111010100111001010011111000110");
        var sBinary = new ScrabbleBinary("0000000000000000000000000000011000111010100111001010011111000110");
        assertEquals(expected2, sString1.addToString(sBinary));
        assertEquals(VALUE_1 + "0000000000000000000000000000011000111010100111001010011111000110", sString1.addToString(sBinary).toString());

        var expected3 = new ScrabbleString(VALUE_1 + "1");
        var sBool = new ScrabbleBool(true);
        assertEquals(expected3, sString1.addToString(sBool));
        assertEquals(VALUE_1 + "1", sString1.addToString(sBool).toString());

        var expected4 = new ScrabbleString(VALUE_1 + "3.2347E-27");
        var sFloat = new ScrabbleFloat(3.2347E-27);
        assertEquals(expected4, sString1.addToString(sFloat));
        assertEquals(VALUE_1 + "3.2347E-27", sString1.addToString(sFloat).toString());

        var expected5 = new ScrabbleString(VALUE_1 + "26");
        var sInt = new ScrabbleInt(26);
        assertEquals(expected5, sString1.addToString(sInt));
        assertEquals(VALUE_1 + "26", sString1.addToString(sInt).toString());
    }

    /**
     * Tests of null methods for coverage, it's assumed that a null return should not be possible.
     */
    @Test
    void nullTest() {
        assertNull(sString1.toScrabbleInt());
        assertNull(sString1.and(sString2));
        assertNull(sString1.or(sString2));
        assertNull(sString1.toScrabbleFloat());
        assertNull(sString1.toScrabbleBool());
        assertNull(sString1.toScrabbleBinary());
        assertNull(sString1.add(sString2));
        assertNull(sString1.subtract(sString2));
        assertNull(sString1.multiply(sString2));
        assertNull(sString1.divide(sString2));
        assertNull(sString1.intPlus(new ScrabbleInt(5)));
        assertNull(sString1.intMinus(new ScrabbleInt(5)));
        assertNull(sString1.intTimes(new ScrabbleInt(5)));
        assertNull(sString1.intDividedBy(new ScrabbleInt(5)));
        assertNull(sString1.floatPlus(new ScrabbleFloat(2.78d)));
        assertNull(sString1.floatMinus(new ScrabbleFloat(2.78d)));
        assertNull(sString1.floatTimes(new ScrabbleFloat(2.78d)));
        assertNull(sString1.floatDividedBy(new ScrabbleFloat(2.78d)));
        assertNull(sString1.binaryPlus(new ScrabbleBinary("111111110101010110")));
        assertNull(sString1.binaryMinus(new ScrabbleBinary("111111110101010110")));
        assertNull(sString1.binaryTimes(new ScrabbleBinary("111111110101010110")));
        assertNull(sString1.binaryDividedBy(new ScrabbleBinary("111111110101010110")));
        assertNull(sString1.negate());
    }
}
