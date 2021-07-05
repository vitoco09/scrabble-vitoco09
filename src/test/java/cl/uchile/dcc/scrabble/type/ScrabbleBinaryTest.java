package cl.uchile.dcc.scrabble.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Testing for ScrabbleBinary class.
 * @author Victor Vidal Paz
 */
public class ScrabbleBinaryTest {

    private ScrabbleBinary sBinaryInt1;
    private ScrabbleBinary sBinaryInt2;
    private ScrabbleBinary sBinaryFloat1;
    private ScrabbleBinary sBinaryFloat2;

    private final String VALUE_1_INT = "0000000000000000000000000000000000000000000000000000001011010111"; // 727
    private final String VALUE_2_INT = "1111111111111111111111111111111111111111111111111111111001011100"; // -420

    // IEEE754 Double precision 64-bit.
    private final String VALUE_1_DOUBLE = "0100000010000110101110000000000000000000000000000000000000000000"; // 727.0
    private final String VALUE_2_DOUBLE = "1100000001111010010000000000000000000000000000000000000000000000"; // -420.0

    // For simplicity the expected results are saved in new constants.
    // 1) Integers (int)
    private final String addN = "0000000000000000000000000000000000000000000000000000000100110011";      // 307
    private final String subtractN = "0000000000000000000000000000000000000000000000000000010001111011"; // 1147
    private final String multiplyN = "1111111111111111111111111111111111111111111110110101011101000100"; // -305340
    private final String divideN = "1111111111111111111111111111111111111111111111111111111111111111";   // -1

    // 2) Floats (double)
    private final String addX = "0100000001110011001100000000000000000000000000000000000000000000";      // 307.0
    private final String subtractX = "0100000010010001111011000000000000000000000000000000000000000000"; // 1147.0
    private final String multiplyX = "1100000100010010101000101111000000000000000000000000000000000000"; // -305340.0
    private final String divideX = "1011111111111011101100011111101100011111101100011111101100100000";   // -1.73095...

    private final int NUM_1 = 727;
    private final int NUM_2 = -420;
    private final double DOUBLE_1 = 727.0d;
    private final double DOUBLE_2 = -420.0d;

    @BeforeEach
    void setUp() {
        sBinaryInt1 = new ScrabbleBinary(VALUE_1_INT);
        sBinaryInt2 = new ScrabbleBinary(VALUE_2_INT);
        sBinaryFloat1 = new ScrabbleBinary(VALUE_1_DOUBLE);
        sBinaryFloat2 = new ScrabbleBinary(VALUE_2_DOUBLE);
    }

    @Test
    void constructorTest() {
        var expectedBinary = new ScrabbleBinary(VALUE_1_INT);
        assertEquals(expectedBinary, sBinaryInt1, "Constructor error");
        assertEquals(expectedBinary.hashCode(), sBinaryInt1.hashCode(), "Constructor Hash error");

        var notExpectedBinary = new ScrabbleBinary(VALUE_2_INT);
        assertNotEquals(notExpectedBinary, sBinaryInt1, "Constructor error");
        assertNotEquals(notExpectedBinary.hashCode(), sBinaryInt1.hashCode(), "Constructor Hash error");
    }

    @Test
    void toScrabbleStringTest() {
        var expectedString = new ScrabbleString(VALUE_1_INT);
        assertEquals(expectedString, sBinaryInt1.toScrabbleString(), "ToScrabbleString error");
        assertEquals(expectedString.hashCode(), sBinaryInt1.toScrabbleString().hashCode(), "toScrabbleString Hash error");
    }

    @Test
    void toScrabbleFloatTest() {
        var expectedFloat = new ScrabbleFloat(DOUBLE_1);
        assertEquals(expectedFloat, sBinaryFloat1.toScrabbleFloat(), "ToScrabbleFloat error");
        assertEquals(expectedFloat.hashCode(), sBinaryFloat1.toScrabbleFloat().hashCode(), "ToScrabbleFloat Hash error");
    }

    @Test
    void toScrabbleInt() {
        var expectedInt1 = new ScrabbleInt(NUM_1);
        assertEquals(expectedInt1, sBinaryInt1.toScrabbleInt(), "toScrabbleInt error");
        assertEquals(expectedInt1.hashCode(), sBinaryInt1.toScrabbleInt().hashCode(), "toScrabbleInt Hash error");

        var expectedInt2 = new ScrabbleInt(NUM_2);
        assertEquals(expectedInt2, sBinaryInt2.toScrabbleInt(), "toScrabbleInt error");
        assertEquals(expectedInt2.hashCode(), sBinaryInt2.toScrabbleInt().hashCode(), "toScrabbleInt Hash error");
    }

    @Test
    void toScrabbleBinaryTest() {
        var expectedBinary = new ScrabbleBinary(VALUE_1_INT);
        assertEquals(expectedBinary, sBinaryInt1.toScrabbleBinary(), "toScrabbleBinary error");
        assertEquals(expectedBinary.hashCode(), sBinaryInt1.toScrabbleBinary().hashCode(), "toScrabbleBinary Hash error");
    }

    @Test
    void toStringTest() {
        assertEquals(VALUE_1_INT, sBinaryInt1.toString(), "toString error");
    }

    @Test
    void andTest() {
        var expected1 = new ScrabbleBinary(VALUE_1_INT);
        assertEquals(expected1, sBinaryInt1.and(new ScrabbleBool(true)), "andTest error");

        var expected2 = new ScrabbleBinary("0".repeat(54) + "1001010100");
        assertEquals(expected2, sBinaryInt1.and(sBinaryInt2), "andTest error");

        var expected3 = new ScrabbleBinary("0".repeat(64));
        assertEquals(expected3, sBinaryInt2.and(new ScrabbleBool(false)), "andTest error");
    }

    @Test
    void orTest() {
        var expected1 = new ScrabbleBinary(VALUE_1_INT);
        assertEquals(expected1, sBinaryInt1.or(new ScrabbleBool(false)), "orTest error");

        var expected2 = new ScrabbleBinary("1".repeat(55) + "011011111");
        assertEquals(expected2, sBinaryInt1.or(sBinaryInt2), "orTest error");

        var expected3 = new ScrabbleBinary("1".repeat(64));
        assertEquals(expected3, sBinaryInt1.or(new ScrabbleBool(true)), "orTest error");
    }

    @Test
    void negateTest() {
        var expected = new ScrabbleBinary("1111111111111111111111111111111111111111111111111111110100101000");
        assertEquals(expected, sBinaryInt1.negate(), "negateTest error");
    }

    @Test
    void addTest() {
        var expectedBinary1 = new ScrabbleBinary(addN);
        assertEquals(expectedBinary1, sBinaryInt1.add(new ScrabbleInt(NUM_2)));

        var expectedBinary2 = new ScrabbleBinary(addN);
        assertEquals(expectedBinary2, sBinaryInt1.add(sBinaryInt2));

        var expectedBinary3 = new ScrabbleBinary(addX);
        assertEquals(expectedBinary3, sBinaryFloat1.add(new ScrabbleFloat(DOUBLE_2)));
    }

    @Test
    void subtractTest() {
        var expectedBinary1 = new ScrabbleBinary(subtractN);
        assertEquals(expectedBinary1, sBinaryInt1.subtract(new ScrabbleInt(NUM_2)));

        var expectedBinary2 = new ScrabbleBinary(subtractN);
        assertEquals(expectedBinary2, sBinaryInt1.subtract(sBinaryInt2));

        var expectedBinary3 = new ScrabbleBinary(subtractX);
        assertEquals(expectedBinary3, sBinaryFloat1.subtract(new ScrabbleFloat(DOUBLE_2)));
    }

    @Test
    void multiplyTest() {
        var expectedBinary1 = new ScrabbleBinary(multiplyN);
        assertEquals(expectedBinary1, sBinaryInt1.multiply(new ScrabbleInt(NUM_2)));

        var expectedBinary2 = new ScrabbleBinary(multiplyN);
        assertEquals(expectedBinary2, sBinaryInt1.multiply(sBinaryInt2));

        var expectedBinary3 = new ScrabbleBinary(multiplyX);
        assertEquals(expectedBinary3, sBinaryFloat1.multiply(new ScrabbleFloat(DOUBLE_2)));
    }

    @Test
    void divideTest() {
        var expectedBinary1 = new ScrabbleBinary(divideN);
        assertEquals(expectedBinary1, sBinaryInt1.divide(new ScrabbleInt(NUM_2)));

        var expectedBinary2 = new ScrabbleBinary(divideN);
        assertEquals(expectedBinary2, sBinaryInt1.divide(sBinaryInt2));

        var expectedBinary3 = new ScrabbleBinary(divideX);
        assertEquals(expectedBinary3, sBinaryFloat1.divide(new ScrabbleFloat(DOUBLE_2)));

    }

    /**
     * Tests of null methods for coverage, it's assumed that a null return should not be possible.
     */
    @Test
    void nullTest() {
        assertNull(sBinaryInt2.toScrabbleBool());
        assertNull(sBinaryInt2.addToString(new ScrabbleString("Hello World")));
    }
}
