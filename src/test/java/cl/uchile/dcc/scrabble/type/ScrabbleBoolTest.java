package cl.uchile.dcc.scrabble.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Testing for ScrabbleBool class.
 * @author Victor Vidal Paz
 */
public class ScrabbleBoolTest {

    private ScrabbleBool sBoolTrue, sBoolFalse;
    private final boolean BOOLEAN_1 = true;
    private final boolean BOOLEAN_2 = false;
    private final String binary = "0100000010000110101110000000000000000000000000000000000000000000";

    @BeforeEach
    void setUp() {
        sBoolTrue = new ScrabbleBool(BOOLEAN_1);
        sBoolFalse = new ScrabbleBool(BOOLEAN_2);
    }

    @Test
    void constructorTest() {
        var expectedBool = new ScrabbleBool(BOOLEAN_1);
        assertEquals(expectedBool, sBoolTrue, "Constructor error");
        assertEquals(expectedBool.hashCode(), sBoolTrue.hashCode(), "Constructor Hash error");

        var notExpectedBool = new ScrabbleBool(BOOLEAN_2);
        assertNotEquals(notExpectedBool, sBoolTrue, "Constructor error");
        assertNotEquals(notExpectedBool.hashCode(), sBoolTrue.hashCode(), "Constructor Hash error");
    }

    @Test
    void toScrabbleStringTest() {
        String aString = BOOLEAN_1 ? "1" : "0";
        var expectedString = new ScrabbleString(aString);
        assertEquals(expectedString, sBoolTrue.toScrabbleString(), "ToScrabbleString error");
        assertEquals(expectedString.hashCode(), sBoolTrue.toScrabbleString().hashCode(), "toScrabbleString Hash error");
    }

    @Test
    void toScrabbleBoolTest() {
        var expectedBool = new ScrabbleBool(BOOLEAN_1);
        assertEquals(expectedBool, sBoolTrue.toScrabbleBool(), "toScrabbleBool error");
        assertEquals(expectedBool.hashCode(), sBoolTrue.toScrabbleBool().hashCode(), "toScrabbleBool Hash error");
    }

    @Test
    void toStringTest() {
        String expected = BOOLEAN_1 ? "1" : "0";
        assertEquals(expected, sBoolTrue.toString(), "toString error");
    }

    @Test
    void andTest() {
        ScrabbleBool expected1 = new ScrabbleBool(false);
        assertEquals(expected1, sBoolTrue.and(new ScrabbleBool(false)), "andTest error");

        ScrabbleBinary expected2 = new ScrabbleBinary(binary);
        assertEquals(expected2, sBoolTrue.and(new ScrabbleBinary(binary)));
        
        ScrabbleBinary expected3 = new ScrabbleBinary("0".repeat(64));
        assertEquals(expected3, sBoolFalse.and(new ScrabbleBinary(binary)));
    }

    @Test
    void orTest() {
        ScrabbleBool expected1 = new ScrabbleBool(true);
        assertEquals(expected1, sBoolTrue.or(new ScrabbleBool(false)), "orTest error");
        assertEquals(expected1, sBoolTrue.or(new ScrabbleBool(true)), "orTest error");

        ScrabbleBinary expected2 = new ScrabbleBinary("1".repeat(64));
        assertEquals(expected2, sBoolTrue.or(new ScrabbleBinary(binary)));

        ScrabbleBinary expected3 = new ScrabbleBinary(binary);
        assertEquals(expected3, sBoolFalse.or(new ScrabbleBinary(binary)));
    }

    @Test
    void negateTest() {
        var expected = new ScrabbleBool(false);
        assertEquals(expected, sBoolTrue.negate(), "negateTest error");
    }

    /**
     * Tests of null methods for coverage, it's assumed that a null return should not be possible.
     */
    @Test
    void nullTest() {
        assertNull(sBoolTrue.toScrabbleInt());
        assertNull(sBoolTrue.toScrabbleFloat());
        assertNull(sBoolTrue.toScrabbleBinary());
        assertNull(sBoolTrue.add(sBoolFalse));
        assertNull(sBoolTrue.subtract(sBoolFalse));
        assertNull(sBoolTrue.multiply(sBoolFalse));
        assertNull(sBoolTrue.divide(sBoolFalse));
        assertNull(sBoolTrue.intPlus(new ScrabbleInt(5)));
        assertNull(sBoolTrue.intMinus(new ScrabbleInt(5)));
        assertNull(sBoolTrue.intTimes(new ScrabbleInt(5)));
        assertNull(sBoolTrue.intDividedBy(new ScrabbleInt(5)));
        assertNull(sBoolTrue.floatPlus(new ScrabbleFloat(2.78d)));
        assertNull(sBoolTrue.floatMinus(new ScrabbleFloat(2.78d)));
        assertNull(sBoolTrue.floatTimes(new ScrabbleFloat(2.78d)));
        assertNull(sBoolTrue.floatDividedBy(new ScrabbleFloat(2.78d)));
        assertNull(sBoolTrue.binaryPlus(new ScrabbleBinary(binary)));
        assertNull(sBoolTrue.binaryMinus(new ScrabbleBinary(binary)));
        assertNull(sBoolTrue.binaryTimes(new ScrabbleBinary(binary)));
        assertNull(sBoolTrue.binaryDividedBy(new ScrabbleBinary(binary)));
        assertNull(sBoolTrue.addToString(new ScrabbleString("Hello World")));
    }
}
